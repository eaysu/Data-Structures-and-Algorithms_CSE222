import homework3.*;
/**
 * Test Class 4
 */
public class TestClass4 {
    
    /**
     * # test case 4
     * @param args # arguments
     */   
    public static void main(String[] args) {
        
        /* Step 1 */
        Account gizemsungu = new Account(1, "gizemsungu", "10.04.1995", "istanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "20.07.1994", "izmir");
        Account gokhankaya = new Account(3, "gokhankaya", "30.10.1987", "ankara");
        Account ayseyilmaz = new Account(4, "ayseyilmaz", "10.04.1990", "bursa");
        Account mehmetozturk = new Account(5, "mehmetozturk", "20.07.1984", "canakkale");
        Account elifyuksel = new Account(6, "elifyuksel", "30.10.1997", "erzurum");
        Account emreaksoy = new Account(7, "emreaksoy", "10.04.1985", "eskisehir");
        Account sedademir = new Account(8, "sedademir", "20.07.1974", "sinop");
        Account ahmetkaraca = new Account(9, "ahmetkaraca", "30.10.1992", "konya");
        Account yaseminarslan = new Account(10, "yaseminarslan", "10.04.1993", "hatay");

        /* Step 2 */
        sibelgulmez.login();
        
        /* Step 3 */
        Post post1 = new Post(1, "I like Java.");
        sibelgulmez.addPost(post1);
        Post post2 = new Post(2, "Java the coffee...");
        sibelgulmez.addPost(post2);
        
        /* Step 4 */
        sibelgulmez.follow("gizemsungu");
        gizemsungu.follower("sibelgulmez");
        sibelgulmez.follow("gokhankaya");
        gokhankaya.follower("sibelgulmez");

        /* Step 5 */
        sibelgulmez.logout();
        
        /* Step 6 */
        gokhankaya.login();

        /* Step 7 */
        gokhankaya.viewProfile(sibelgulmez);
        
        /* Step 8 */
        gokhankaya.viewPosts(sibelgulmez);

        /* Step 9 */
        Like like1 = new Like(post1, "gokhankaya", 1);
        post1.addLike(like1);

        /* Step 10 */
        Comment comment1 = new Comment(post1, 1, "gokhankaya", "me too!");
        post1.addComment(comment1);

        /* Step 11 */
        gokhankaya.follow("sibelgulmez");
        sibelgulmez.follower("gokhankaya");
        gokhankaya.follow("gizemsungu");
        gizemsungu.follower("gokhankaya");

        /* Step 12 */
        Message message1 = new Message(1, "gokhankaya", "gizemsungu", "This homework is too easy!");
        gizemsungu.addInbox(message1);
        gokhankaya.addOutbox(message1);
        
        /* Step 13 */
        gokhankaya.logout();
        
        /* Step 14 */
        gizemsungu.login();

        /* Step 15 */
        gizemsungu.checkOutbox();

        /* Step 16 */
        gizemsungu.checkInbox();

        /* Step 17 */
        gizemsungu.viewInbox();

        /* Step 18 */
        gizemsungu.viewProfile(sibelgulmez);

        /* Step 19 */
        gizemsungu.viewPosts(sibelgulmez);

        /* Step 20 */
        gizemsungu.viewPostInteraction(sibelgulmez);

        /* Step 21 */
        Like like2 = new Like(post1, "gizemsungu", 2);
        post1.addLike(like2);
        Like like3 = new Like(post2, "gizemsungu", 3);
        post2.addLike(like3);

        /* Step 22 */
        gizemsungu.viewPostInteraction(sibelgulmez);

        /* Step 23 */
        Post post3 = new Post(3, "I like Java.");
        gizemsungu.addPost(post3);
        Post post4 = new Post(4, "Java the coffee...");
        gizemsungu.addPost(post4);
        gizemsungu.logout();

        /* Step 24 */
        sibelgulmez.login();
        sibelgulmez.viewProfile(gizemsungu);
        Like like4 = new Like(post3, "sibelgulmez", 4);
        post3.addLike(like4);
        sibelgulmez.logout();

        /* Step 25 */
        gokhankaya.login();
        gokhankaya.viewProfile(gizemsungu);
        Comment comment2 = new Comment(post4, 2, "gokhankaya", "Nice!");
        post4.addComment(comment2);
        Message message2 = new Message(2, "gokhankaya", "gizemsungu", "Hello!");
        gizemsungu.addInbox(message2);
        gokhankaya.addOutbox(message2);
        gokhankaya.logout();

        /* Step 26 */
        gizemsungu.login();
        gizemsungu.viewProfile(gizemsungu);
        gizemsungu.checkInbox();
        gizemsungu.viewInbox();
        gizemsungu.block("sibelgulmez");
        gizemsungu.logout();

        /* Step 27 */
        sibelgulmez.login();
        sibelgulmez.viewProfile(gizemsungu);
        sibelgulmez.viewPostInteraction(gizemsungu);
        sibelgulmez.logout();

        /* Step 28 */
        ayseyilmaz.login();
        ayseyilmaz.follow("mehmetozturk");
        ayseyilmaz.unfollow("mehmetozturk");
        ayseyilmaz.logout();

        mehmetozturk.login();
        mehmetozturk.viewProfile(mehmetozturk);
        mehmetozturk.logout();

        elifyuksel.login();
        Post post5 = new Post(5, "What a beautiful day");
        elifyuksel.addPost(post5);
        elifyuksel.logout();

        emreaksoy.login();
        Like like5 = new Like(post5, "emreaksoy", 4);
        post5.addLike(like5);
        post5.removeLike(like5);
        emreaksoy.viewPostInteraction(elifyuksel);
        emreaksoy.logout();

        sedademir.login();
        Post post6 = new Post(6, "To be or not to be");
        sedademir.addPost(post6);
        sedademir.logout();

        ahmetkaraca.login();
        Comment comment3 = new Comment(post4, 3, "ahmetkaraca", "Wise words!");
        post5.addComment(comment3);
        post5.removeComment(comment3);
        ahmetkaraca.viewPostInteraction(sedademir);
        ahmetkaraca.logout();

        yaseminarslan.login();
        yaseminarslan.block("ayseyilmaz");
        yaseminarslan.logout();

        ayseyilmaz.login();
        ayseyilmaz.viewProfile(yaseminarslan);
        ayseyilmaz.logout();

        yaseminarslan.login();
        yaseminarslan.unblock("ayseyilmaz");
        yaseminarslan.logout();

        ayseyilmaz.login();
        ayseyilmaz.viewProfile(yaseminarslan);
        ayseyilmaz.logout();
    }
}