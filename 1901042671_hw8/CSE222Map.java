import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * # CSE222Map class.
 */
public class CSE222Map {

    private String FileName;
    private int [][] map;
    private int mapSize;
    private int startX;
    private int startY;
    private int endX;
    private int endY;


    /**
     * # Constructs a map object.
     * @param FileName the file path of the map
     * @param X_SIZE the row size of the map
     * @param Y_SIZE the column size of the map
     */
    public CSE222Map(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.map = new int[X_SIZE][Y_SIZE];
        this.mapSize = X_SIZE;

        fileToMap();
    }


    /**
     * # Retrieves the value at the specified coordinates on the map.
     * @param y # y coordinate
     * @param x # x coordinate
     * @return # the value at the specified coordinates
     */
    public int getCoordinate(int y, int x) {
        return map[y][x];
    }

    /**
     * # Retrieves the size of the map.
     * @return # size of the map
     */
    public int getSize() {
        return mapSize;
    }


    /**
     * # Retrieves the starting y-coordinate of the map.
     * @return # starting y coordinate
     */
    public int getStartY() {
        return startY;
    }


    /**
     * # Retrieves the starting x-coordinate of the map.
     * @return # starting x coordinate
     */
    public int getStartX() {
        return startX;
    }


    /**
     * # Retrieves the ending y-coordinate of the map.
     * @return # ending y coordinate
     */
    public int getEndY() {
        return endY;
    }

    /**
     * # Retrieves the ending x-coordinate of the map.
     * @return # ending x coordinate
     */
    public int getEndX() {
        return endX;
    }


    /**
     * # Retrieves the map as a 2D array.
     * @return # the map
     */
    public int[][] getMap() {
        return map;
    }


    /**
     * # Reads the map data from the file and stores it in the map array.
     * # Also keeps track of the start and end points.
     */
    private void fileToMap() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {

            int i = 0;
            String lines;

            while ((lines = reader.readLine()) != null) {

                if (i == 0) {
                    startY = Integer.parseInt(lines.split(",")[0].trim());
                    startX = Integer.parseInt(lines.split(",")[1].trim());
                    i++;
                    continue;
                }

                if (i == 1) {
                    endY = Integer.parseInt(lines.split(",")[0].trim());
                    endX = Integer.parseInt(lines.split(",")[1].trim());
                    i++;
                    continue;
                }

                String[] values = lines.split(",");
                for (int j = 0; j < values.length; j++) {
                    if (values[j].trim().equals("1") || values[j].trim().equals("-1")) {
                        map[i - 2][j] = 1;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (map[startY][startX] != 0 || map[endY][endX] != 0) {
            System.out.println("Start or end points cannot include obstacles");
            System.out.println("Start Point: " + map[startY][startX] + " End Point: " + map[endY][endX]);
        }
    }


    /**
     * # Converts the map to a png image.
     */
    public void convertPNG() {
        int width = mapSize;
        int height = mapSize;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // Set obstacle color as black and unobstacle color as white
        Color obstacleColor = Color.BLACK;
        Color unobstacleColor = Color.WHITE;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (map[y][x] == 0) {
                    g.setColor(unobstacleColor);
                } else {
                    g.setColor(obstacleColor);
                }

                g.fillRect(x, y, 1, 1);
            }
        }

        g.dispose();

        try {
            // Save the image as a PNG file
            File output = new File("map.png");
            ImageIO.write(image, "png", output);
            System.out.println("Map converted to PNG: " + output.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to convert map to PNG: " + e.getMessage());
        }
    }


    /**
     * # Draws the path on the map image based on the specified algorithm.
     * @param path # the path to be drawn
     * @param algorithm  # the algorithm used to find the path
     */
    public void drawLine(List<Integer> path, String algorithm) {
        try {
            // Load the map image
            BufferedImage image = ImageIO.read(new File("map.png"));
            Graphics2D g = image.createGraphics();

            // Set line color based on the algorithm
            Color lineColor;
            if (algorithm.equals("Dijkstra")) {
                lineColor = Color.RED;
            } else if (algorithm.equals("BFS")) {
                lineColor = Color.BLUE;
            } else {
                throw new IllegalArgumentException("Invalid algorithm: " + algorithm);
            }

            // Draw the path on the map
            g.setColor(lineColor);
            for (int i = 0; i < path.size() - 1; i++) {
                int node1 = path.get(i);
                int node2 = path.get(i + 1);

                int x1 = node1 % mapSize;
                int y1 = node1 / mapSize;
                int x2 = node2 % mapSize;
                int y2 = node2 / mapSize;

                g.drawLine(x1, y1, x2, y2);
            }

            g.dispose();

            File output = new File(algorithm + "_map.png");
            ImageIO.write(image, "png", output);
            System.out.println("Path drawn on " + algorithm + " map: " + output.getAbsolutePath());
        } 
        
        catch (IOException e) {
            System.out.println("Failed to draw path on " + algorithm + " map: " + e.getMessage());
        }
    }
    

    /**
     * # Writes the path coordinates to a file.
     * @param path # the path to be written
     * @param fileName # the name of the file
     */
    public void writePath(List<Integer> path, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Integer node : path) {
                int x = node % mapSize;
                int y = node / mapSize;
                writer.write(y + ", " + x + "\n");
            }
            System.out.println("Path written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}