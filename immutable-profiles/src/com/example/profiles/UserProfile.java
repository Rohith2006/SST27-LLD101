package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(String id, String email, String phone, String displayName, String address, boolean marketingOptIn, String twitter, String github) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.displayName = displayName;
        this.address = address;
        this.marketingOptIn = marketingOptIn;
        this.twitter = twitter;
        this.github = github;
    }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    public static class ProfileBuilder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public static ProfileBuilder create() {
            return new ProfileBuilder();
        }

        public ProfileBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ProfileBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ProfileBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public ProfileBuilder setDisplayName(String displayName) {
            if (Validation.isBlank(displayName)) {
                throw new IllegalArgumentException("Display name cannot be blank");
            }
            this.displayName = displayName;
            return this;
        }

        public ProfileBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ProfileBuilder setMarketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public ProfileBuilder setTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public ProfileBuilder setGithub(String github) {
            this.github = github;
            return this;
        }

        public UserProfile build() {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);
            return new UserProfile(id, email, phone, displayName, address, marketingOptIn, twitter, github);
        }
    }
}

