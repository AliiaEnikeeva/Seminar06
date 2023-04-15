package VetProgram;

public class Owner {
    public String nameOwner;
    public String phone;

    public Owner(String nameOwner, String phone) {
        this.nameOwner = nameOwner;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner)
            return ((Owner) obj).nameOwner.equals(this.nameOwner) &&
                    ((Owner) obj).phone.equals(this.phone);
        else return false;
    }
}
