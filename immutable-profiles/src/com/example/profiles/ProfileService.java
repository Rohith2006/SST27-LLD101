package com.example.profiles;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {
    

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        return UserProfile.ProfileBuilder.create()
                .setId(id)
                .setEmail(email)
                .build();
    }

    // No updateDisplayName method: UserProfile is now immutable
}
