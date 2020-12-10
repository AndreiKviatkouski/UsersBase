package by.AndreiKviatkouski.domain;

public class Role {
    public final static int SUPER_ADMIN = 1;
    public final static int ADMIN = 2;
    public final static int PROVIDER = 2;
    public final static int USER = 3;
    public final static int CUSTOMER = 3;

    private Integer level;
     public Role (int level){
         this.level =level;
     }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        Role o2= (Role) o;
        return level.equals(o2.getLevel());
    }
}
