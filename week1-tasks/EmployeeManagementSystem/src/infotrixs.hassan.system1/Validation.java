package infotrixs.hassan.system1;

public class Validation {
    public static boolean isValidId(String id) {
        // Add your ID validation logic here
        if(id.length() < 3){
            System.out.println("ID should be at least 3 characters long");
            return false;
        }
        return true;
    }

    public static boolean isValidName(String name) {
        // Add your name validation logic here
        if(name.length() < 3){
            System.out.println("Name must be at least 3 characters long");
            return false;
        }
        if (name.matches(".*\\d.*")) {
            System.out.println("Name must not contain any digit");
            return false;
        }

        return true;
    }

    public static boolean isValidDesignation(String designation) {
        // Add your designation validation logic here
        if (designation.isEmpty()){
            System.out.println("Designation must not be empty");
            return false;
        }
        return true;
    }
}