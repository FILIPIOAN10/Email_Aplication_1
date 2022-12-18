import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
/**
 Email Application ------------------------------------------------------------------------------------------- Scenario:
 You are an IT Support Administrator Specialist and are charged with the task of creating email accounts for new hires.

 Your application should do the following:
 • Verify that the email is respecting with the following syntax:              firstname.lastname@department.company.com
 • Assign a department (sales, development, accounting) for new hires, if none leave blank
 • Generate a random String for a password, that is respecting the following rules:
 - A password must have at least eight characters.
 - A password consists of only letters and digits.
 - A password must contain at least two digits.
 • Have methods to change the password, the mailbox capacity, and define an alternate email address
 • Have methods to display the full name, email and alternate email, mailbox capacity and department
 • In order to be able to do new hires, you must check first if they have age greater than 18 years, and you know the CNP
 information and also the CNP is containing exact 13 characters and all of them are digits
 • You will need to make sure that when a new hire will be assigned to development department, you will generate for them
 a random serial number (max 10 characters and can contain digits and letters) for a computer. Only development team will
 have a computer.
 • When a new hire is done for sales or accounting, a random phone number will be random generated (exact 10 characters
 and can contain only digits)
 • You will need to make sure that if the department is not specified than the new hire will not have a phone number and
 will not have a computer
 • You will need to create new hires (at least one for every department, one without department) from a main method, and
 you should need to be able to do all the operations requested                                                        */

public class NewHire {
    private String cnp;
    private String firstName;
    private String lastName;
    private String department;
    private String company;
    private String email;
    private String password;
    private int mailBoxCapacity;
    private String phoneNumber;
    private String serialNumber;
    private String alternativeEmail;

    /**
     În NewHire - validare cnp, unde apelăm metodele
     !hasDigits || !verifyFormatMonth(cnp) || !verifyFormatYear(cnp) și metoda showAge(cnp)
     */
    public NewHire(String cnp) {
        boolean hasDigits = true;
        for (int i = 0; i < cnp.length(); i++) {
            if (!Character.isDigit(cnp.charAt(i))) {
                hasDigits = false;
            }
        }
        if (cnp.length() != 13 || !hasDigits || !verifyFormatMonth(cnp) || !verifyFormatYear(cnp)) {
            System.out.println("This cnp is invalid!");}
        else if (showAge(cnp) < 18) {
            System.out.println("The employee is under 18 and cannot be hired.");}
        else {
            this.cnp = cnp;
            mailBoxCapacity = 300;}
    }

    static int calcAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public static int showAge(String cnp) {
        char result1 = cnp.charAt(1);
        char result2 = cnp.charAt(2);

        String year19__ = "19" + result1 + result2;
        String year20__ = "20" + result1 + result2;
        String month = String.valueOf(cnp.charAt(3)) + cnp.charAt(4); // se poate modifica?@
        String day = String.valueOf(cnp.charAt(5)) + cnp.charAt(6);

        String string19__ = year19__ + "-" + month + "-" + day;
        String string20__ = year20__ + "-" + month + "-" + day;

        char s = cnp.charAt(0); // aici s-a făcut modificare@
        LocalDate dateOfBirth = null;
        if (s == '1' || s == '2') {
            dateOfBirth = LocalDate.parse(string19__);
            System.out.format("%-39s: %s%n", "Age is", calcAge(dateOfBirth));
        }
        else if (s == '5' || s == '6') {
            dateOfBirth = LocalDate.parse(string20__);
            System.out.format("%-39s: %s%n", "Age is", calcAge(dateOfBirth));}
        return calcAge(dateOfBirth);
    }

    /**
     Verificăm dacă anul este introdus corect
     */
    public static boolean verifyFormatYear(String cnp){
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            String year = cnp.substring(1, 3);
            int yearAsInt = Integer.parseInt(year);
            return yearAsInt >= 0 && yearAsInt <= 99;}
        else if (cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            String year = cnp.substring(1, 3);
            int yearAsInt = Integer.parseInt(year);
            return yearAsInt >= 0 && yearAsInt <= 21; }
        return false;
    }

    /**
     Verificăm luna în funcție de câte zile sunt în lună
     */
    public static boolean verifyFormatMonth(String cnp) {
        String year = cnp.substring(1,3);
        int yearAsInt = Integer.parseInt(year);
        String month = cnp.substring(3,5);
        int monthAsInt = Integer.parseInt(month);
        String day= cnp.substring(5,7);
        int dayAsInt = Integer.parseInt(day);
        if(monthAsInt <1 || monthAsInt >12){
            return false;}
        else {
            if(monthAsInt == 1 ||monthAsInt == 3 ||monthAsInt == 5 ||monthAsInt == 7 ||
                    monthAsInt == 8 ||monthAsInt == 10 ||monthAsInt == 12){
                return  dayAsInt >= 1 && dayAsInt <=31;}
            else if (monthAsInt == 4 ||monthAsInt == 6 ||monthAsInt == 9 ||monthAsInt == 11){
                return  dayAsInt >= 1 && dayAsInt <=30;}
            else {
                if (yearAsInt%4 == 0){
                    return dayAsInt >=1 && dayAsInt <= 29;}
                else {
                    return dayAsInt >=1 && dayAsInt <= 28;}
            }
        }
    }

    /**
     În NewHire - validare cnp, unde apelăm metodele
     !hasDigits || !verifyFormatMonth(cnp) || !verifyFormatYear(cnp) și metoda showAge(cnp)
     */
    public void setEmail() {
        if(checkValues()){
            if (this.department == null || this.department.equals("")){
                this.email = firstName.toLowerCase() + "." + lastName.toLowerCase()
                        + "@" + company.replace(" ", "_").toLowerCase() + ".com";}
            else {
                this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"
                        + department.toLowerCase() + "." + company.replace(" ", "_").toLowerCase()
                        + ".com";}
        }
        else {
            System.out.println("The email address cannot be set. Verify first name, last name or company's name!");
        }
    }
    /**
     Verificăm ca valorile introduse să nu fie nule și să fie compuse numai din litere. Se folosește și metoda
     valuesHasOnlyletters
     */
    public boolean checkValues() {
        if (firstName == null || firstName.equals("") || valuesHasOnlyLetters(firstName)) {
            return false;}
        if (lastName == null  || lastName.equals("") || valuesHasOnlyLetters(lastName)) {
            return false;}
        if (company == null || company.equals("")) {
            return false;}
        return true;
    }

    public static boolean valuesHasOnlyLetters(String stringValue){
        for (int i = 0; i <stringValue.length(); i++){
            if (!Character.isLetter(stringValue.charAt(i))){
                return true;}
        }
        return false;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() >= 1){
            this.firstName = firstName;
        } else {
            System.out.println("First name not set, it must have at least one character");
            }
        }


    public void setLastName(String lastName) {
        if(lastName.length() >= 1){
            this.lastName = lastName;
        } else {
            System.out.println("Last name not set, it must have at least one character");
        }
    }

    public String getCompany() {
        return company;}

    public void setCompany(String company) {
        this.company = company;}

    public void displayEmail(){
        System.out.format("%-39s: %s%n", "The first email is", email);
    }

    // Stabilim departamentul în care va lucra noul angajat și îi atribuim un număr de telefon sau număr de serie în
    // funcție de departament
    public void setDepartment(String department) {
        if (department.equalsIgnoreCase("sales")|| department.equalsIgnoreCase("accounting")) {
            this.department = department;
            this.phoneNumber =  assignPhoneNumber();}
        else if (department.equalsIgnoreCase("development")) {
            this.department = department;
            this.serialNumber = assignSerialNumber(); } else {
            this.department = "";
        }
    }

    public void displayDepartament () {
        System.out.format("%-39s: %s%n", "The department is", department);
    }

    public String getDepartment() {
        return department;
    }



    public static String assignPhoneNumber() {
        String phoneNumberSet = "0123456789";
        int phoneNumberLength = 10;
        char[] phoneNumber = new char[phoneNumberLength];
        for (int i = 0; i < phoneNumberLength; i++) {
            int randomIndex = (int) (Math.random() * phoneNumberSet.length());
            phoneNumber[i] = phoneNumberSet.charAt(randomIndex);}
        return new String(phoneNumber);
    }
    public String getPhoneNumber() {
        return String.format("%-39s: %s","The phone number is", phoneNumber);
    }

    public static String assignSerialNumber(){
        String computerSerialSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int computerSerialLength = (int) (Math.random() * 10 + 1);
        char[] computerSerialNumber = new char[computerSerialLength];

        for (int i = 0; i < computerSerialLength; i++) {
            int randomIndex = (int) (Math.random() * computerSerialSet.length());
            computerSerialNumber[i] = computerSerialSet.charAt(randomIndex);}
        return new String(computerSerialNumber);
    }


    public String getSerialNumber() {
        return String.format("%-39s: %s", "The computer serial number is", serialNumber);
    }

    // Se generează parola pentru noul angajat. Se folosește și metoda hasMin2Digits pentru a verifica dacă parola
    // conține cel puțin două cifre
    public void generatePassword() {
        Random random = new Random();
        String digits = "0123456789";
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int passwordLength = random.nextInt(13) + 8;
        String password = "";
        while (!hasMin2Digits(password)) {
            for (int i = 0; i < passwordLength; i++) {
                int digitOrLetter = random.nextInt(2);
                int randomDigit = random.nextInt(digits.length());  // 10
                int randomLetter = random.nextInt(letters.length()); // 52

                if (digitOrLetter == 0) {
                    password += digits.charAt(randomDigit);}
                else {
                    password += letters.charAt(randomLetter);}
            }
        }
        this.password = password;
    }

    public static boolean hasMin2Digits(String password) {  // it was named hasMin2DigitsAnd2Letters
        int noOfDigits = 0;
        int noOfLetters = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                noOfDigits++;}
            else {
                noOfLetters++;}
        }
        return noOfDigits >= 2 && noOfLetters >= 0;  //  it was return noOfDigits >= 2 && noOfLetters >= 2 @
    }
    // Schimbare parolei
    public void changePassword(String newPassword) {
        if (this.password == null){
            System.out.println("The password has not been set yet.");}
        else if(hasMin2Digits(newPassword) && newPassword.length() >= 8) {
            this.password = newPassword;
            System.out.format("%-39s: %s%n", "The new password for the first email is", this.password);}
        else {
            System.out.println("The new password must have at least 2 letters, " +
                    "2 digits and must be at least 8 characters long. " +
                    "The password has not been updated!");}
    }
    // Generează a doua parolă, cea setată de noi
    public String getPassword() {
        return String.format("%-39s: %s", "The password is", password);
    }

    // Ne afișează capacitate căsuței de email
    public void displayMailBoxCapacity (){
        System.out.format("%-39s: %s%n","The capacity of the first mailbox is", mailBoxCapacity + " mb.");
    }

    // Ne ajută setăm o nouă capacitate a căsuței de email
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;}

    //    public int getMailBoxCapacity() {
//        System.out.print("The new capacity of the first mailbox  : " );
//        return mailBoxCapacity;
////        System.out.format("%-39s: %s%n","The capacity of the first mailbox is modif", mailBoxCapacity + " mb.");
//    }
    // ne afișează ce am setat
    public void getMailBoxCapacity() {
        System.out.format("%-39s: %s%n","The new capacity of the first mailbox", mailBoxCapacity + " mb." );
    }
    // setăm o nouă adresă de email ...
    public void setAlternativeEmail(String alternativeEmail) {
        String [] personalEmail = alternativeEmail.split("@");
        if (personalEmail.length == 2){
            this.alternativeEmail = alternativeEmail;}
        else {
            System.out.println("Invalid email address");}
    }
    // ... și o afișăm
    public void displayAlternativeEmail () {
        System.out.format("%-39s: %s%n", "The alternative email is",  alternativeEmail);
    }

    public void displayFullName () {  // @ modificare
        if (firstName == null || lastName == null) {
            System.out.println("First name or last name has not been set yet");
        } else {
            System.out.format("%-39s: %s%n", "The full name is",
                    Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1).toLowerCase()
                            + " " + Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1).toLowerCase());
        }
    }
}
