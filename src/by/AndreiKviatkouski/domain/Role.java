package by.AndreiKviatkouski.domain;

public class Role {
    public final static int SUPER_ADMIN_level = 3;
    public final static int ADMIN_level = 2;
    public final static int PROVIDER_level = 2;
    public final static int USER_level = 1;
    public final static int CUSTOMER_level = 1;
    public final static String SUPER_ADMIN_str = "SUPER_ADMIN";
    public final static String ADMIN_str = "ADMIN";
    public final static String PROVIDER_str = "PROVIDER";
    public final static String USER_str = "USER";
    public final static String CUSTOMER_str = "CUSTOMER";

    private Integer level;
    private String description;


    public Role(Integer level, String description) {
        this.level = level;
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        Role o2 = (Role) o;
        return level.equals(o2.getLevel());
    }



    @Override
    public String toString() {
        return "Role{" +
                "level=" + String.valueOf(level) +
                ", description='" + String.valueOf(description) + '\'' +
                '}';
    }
}

