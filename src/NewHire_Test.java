public class NewHire_Test {
    public static void main(String[] args) {
        //        Age is                                 : 18
//        The full name is                       : Archilbald Goldstein
//        The first email is                     : archilbald.goldstein@sales.google.com
//        The department is                      : sales
//        The password is                        : bh4tv15m8uG
//        The phone number is                    : 5623137511
//        The computer serial number is          : null
//        The new password for the first email is: qwert25iophsdgf
//        The capacity of the first mailbox is   : 300 mb.
//                The capacity of the first mailbox is   : 550 mb.
//                The alternative email is               : admin@admin.com


        NewHire newHire = new NewHire("5040214573825");
        newHire.setFirstName("");
        newHire.setLastName("Goldstein");
        newHire.displayFullName();
        newHire.setCompany("Google");
        newHire.setDepartment("sales");
        newHire.setEmail();
        newHire.displayEmail();
        newHire.displayDepartament();
        System.out.println(newHire.getPhoneNumber());
        System.out.println(newHire.getSerialNumber()); // nu ați adăugat
        newHire.generatePassword();
        System.out.println(newHire.getPassword());
        newHire.changePassword("qwert25iophsdgf");
        newHire.displayMailBoxCapacity();
        newHire.setMailBoxCapacity(550);
        newHire.getMailBoxCapacity();
        newHire.setAlternativeEmail("admin@admin.com");
        newHire.displayAlternativeEmail();
//        System.out.println(newHire.getMailBoxCapacity());
        System.out.println();

        NewHire newHire2 = new NewHire("1940214573825");
        newHire2.setFirstName("GrOSu");
        newHire2.setLastName("CătăLIN");
        newHire2.displayFullName();
        newHire2.setCompany("Saudi AraMCO");
        newHire2.setDepartment("accounting");
        newHire2.setEmail();
        newHire2.displayEmail();
        newHire2.displayDepartament();
        System.out.println(newHire2.getPhoneNumber());
        System.out.println(newHire2.getSerialNumber()); // nu ați adăugat
        newHire2.generatePassword();
        System.out.println(newHire2.getPassword());
        newHire2.changePassword("qwert25iophsdgf");
        newHire2.displayMailBoxCapacity();
        newHire2.setMailBoxCapacity(550);
        newHire2.getMailBoxCapacity();
        newHire2.setAlternativeEmail("admin2@admin.com");
        newHire2.displayAlternativeEmail();
//        System.out.println(newHire2.getMailBoxCapacity());
        System.out.println();

        NewHire newHire3 = new NewHire("1940214573825");
        newHire3.setFirstName("SILvia");
        newHire3.setLastName("MaRin");
        newHire3.displayFullName();
        newHire3.setCompany("IBM");
        newHire3.setDepartment("development");
        newHire3.setEmail();
        newHire3.displayEmail();
        newHire3.displayDepartament();
        System.out.println(newHire3.getPhoneNumber());
        System.out.println(newHire3.getSerialNumber()); // nu ați adăugat
        newHire3.generatePassword();
        System.out.println(newHire3.getPassword());
        newHire3.changePassword("qwert34bskjd");
        newHire3.displayMailBoxCapacity();
        newHire3.setMailBoxCapacity(550);
        newHire3.getMailBoxCapacity();
        newHire3.setAlternativeEmail("admin3@admin.com");
        newHire3.displayAlternativeEmail();
//        System.out.println(newHire3.getMailBoxCapacity());
        System.out.println();


        NewHire newHire4 = new NewHire("1940214573825");
        newHire4.setFirstName("George");
        newHire4.setLastName("Petrescu");
        newHire4.displayFullName();
        newHire4.setCompany("IBM");
        newHire4.setDepartment("");
        newHire4.setEmail();
        newHire4.displayEmail();
        newHire4.displayDepartament();
        System.out.println(newHire4.getPhoneNumber());
        System.out.println(newHire4.getSerialNumber()); // nu ați adăugat
        newHire4.generatePassword();
        System.out.println(newHire4.getPassword());
        newHire4.changePassword("qwert34");
        newHire4.displayMailBoxCapacity();
        newHire4.setMailBoxCapacity(550);
        newHire4.getMailBoxCapacity();
        newHire4.setAlternativeEmail("admin4@admin.com");
        newHire4.displayAlternativeEmail();
//        System.out.println(newHire4.getMailBoxCapacity());
        System.out.println();
    }
}
