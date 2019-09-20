import java.util.HashMap;

public class PhoneBook {
    public static void main(String[] args) {
        // Telephone book
        // We are going to represent our contacts in a map where the keys are
        // going to be strings and the values are going to be strings as well.
        // ======================================================================================
        // Create a map with the following key-value pairs.
        HashMap<String, String> phoneBook = new HashMap<>();
        /*
                Name (key)	         Phone number (value)
            William A. Lathan	        405-709-1865
            John K. Miller	            402-247-8568
            Hortensia E. Foster	        606-481-6467
            Amanda D. Newland	        319-243-5613
            Brooke P. Askew	            307-687-2982
         */
        phoneBook.put("William A. Lathan", "405-709-1865");
        phoneBook.put("John K. Miller", "402-247-8568");
        phoneBook.put("Hortensia E. Foster", "606-481-6467");
        phoneBook.put("Amanda D. Newland", "319-243-5613");
        phoneBook.put("Brooke P. Askew", "307-687-2982");
        // ======================================================================================
        /*
        Create an application which solves the following problems.

              - What is John K. Miller's phone number?
              - Whose phone number is 307-687-2982?
              - Do we know Chris E. Myers' phone number?
         */
        // ======================================================================================
        System.out.println("What is John K. Miller's phone number?");
        String phoneNumber1 = phoneBook.get("John K. Miller");
        System.out.println(phoneNumber1);
        System.out.println();
        // ======================================================================================
        System.out.println("Whose phone number is 307-687-2982?");
        for (HashMap.Entry<String, String> myIter : phoneBook.entrySet()) {
            if ("307-687-2982".equals(myIter.getValue())) {
                System.out.println("It is " + myIter.getKey() + "'s phone number.");
                break;
            }
        }
        System.out.println();
        // ======================================================================================
        System.out.println("Do we know Chris E. Myers' phone number?");
        if (phoneBook.containsKey("Chris E. Myers")) {
            System.out.println("Yes, it is: " + phoneBook.get("Chris E. Myers"));
        } else {
            System.out.println("No, sorry.");
        }
        System.out.println();
    }
}
