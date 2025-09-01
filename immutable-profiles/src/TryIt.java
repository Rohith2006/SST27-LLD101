import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        // ProfileService svc = new ProfileService();
        // UserProfile p = svc.createMinimal("u1", "a@b.com");
        // System.out.println("Before: " + p.getEmail());
        // p.setEmail("evil@example.com"); // demonstrates mutability problem
        // System.out.println("After:  " + p.getEmail());
        // System.out.println("=> In the solution, this setter disappears and object becomes immutable.");

        UserProfile p2 = UserProfile.ProfileBuilder.create()
                .setId("u2")
                .setEmail("b@b.com")
                .setPhone("123-456-7890")
                .setDisplayName("User Two")
                .setAddress("456 Elm St")
                .setMarketingOptIn(true)
                .setTwitter("user2_twitter")
                .setGithub("user2_github")
                .build();

        System.out.println("UserProfile created: " + p2);
        System.out.println("Email: " + p2.getEmail());
        System.out.println("Display Name: " + p2.getDisplayName());

        // p2.setEmail("evil@example.com"); // Error: setEmail is not accessible

    }
}
