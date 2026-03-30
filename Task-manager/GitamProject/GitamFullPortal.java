import java.util.Scanner;

public class GitamFullPortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.println("       GITAM UNIVERSITY - ADMISSION PORTAL        ");
        System.out.println("           Transformation Begins Here             ");
        System.out.println("***************************************************");

        // 1. BASIC REGISTRATION
        System.out.print("\nEnter Applicant Name *: ");
        String name = sc.nextLine();

        System.out.print("Enter Email Address *: ");
        String email = sc.nextLine();

        System.out.print("Enter Mobile Number (+91) *: ");
        String mobile = sc.nextLine();

        // 2. OTP LOGIC (Verification)
        int generatedOTP = (int)(Math.random() * 9000) + 1000;
        System.out.println("\n[SYSTEM] OTP sent to " + mobile + " is: " + generatedOTP);
        System.out.print("Enter OTP to Verify: ");
        int userOTP = sc.nextInt();
        sc.nextLine(); // buffer clear

        if (userOTP != generatedOTP) {
            System.out.println("\nALERT: Verification Failed! Access Denied.");
            return;
        }
        System.out.println("SUCCESS: Mobile Verified Successfully.");

        // 3. DEPARTMENT & SUBJECT SELECTION
        System.out.println("\n--- SELECT YOUR SCHOOL/DEPARTMENT ---");
        System.out.println("1. School of Technology (Engineering)");
        System.out.println("2. School of Business (Management)");
        System.out.println("3. School of Humanities (B.A. / Social Sciences)");
        System.out.print("Enter Choice (1-3): ");
        int deptChoice = sc.nextInt();
        sc.nextLine();

        String deptName = "", selectedCourse = "";
        double annualFees = 0;

        switch (deptChoice) {
            case 1:
                deptName = "School of Technology";
                System.out.println("\nCourses: 1. B.Tech CSE (4.5L) | 2. B.Tech ECE (3.5L) | 3. B.Tech Mechanical (3L)");
                int c1 = sc.nextInt();
                selectedCourse = (c1 == 1) ? "B.Tech CSE" : (c1 == 2) ? "B.Tech ECE" : "B.Tech Mechanical";
                annualFees = (c1 == 1) ? 450000 : (c1 == 2) ? 350000 : 300000;
                break;
            case 2:
                deptName = "School of Business";
                System.out.println("\nCourses: 1. MBA (5L) | 2. BBA (2.5L) | 3. B.Com (1.8L)");
                int c2 = sc.nextInt();
                selectedCourse = (c2 == 1) ? "MBA" : (c2 == 2) ? "BBA" : "B.Com";
                annualFees = (c2 == 1) ? 500000 : (c2 == 2) ? 250000 : 180000;
                break;
            case 3:
                deptName = "School of Humanities";
                System.out.println("\nCourses: 1. B.A. Psychology (1.2L) | 2. B.A. English (1L) | 3. B.A. Pol Science (1L)");
                int c3 = sc.nextInt();
                selectedCourse = (c3 == 1) ? "B.A. Psychology" : (c3 == 2) ? "B.A. English" : "B.A. Political Science";
                annualFees = (c3 == 1) ? 120000 : 100000;
                break;
            default:
                System.out.println("Invalid Selection!"); return;
        }

        // 4. CAMPUS SELECTION
        sc.nextLine();
        System.out.print("\nSelect Campus (Visakhapatnam / Hyderabad / Bengaluru): ");
        String campus = sc.nextLine();

        // 5. FINAL ADMISSION SUMMARY (Receipt)
        System.out.println("\n===================================================");
        System.out.println("            OFFICIAL ADMISSION RECEIPT             ");
        System.out.println("===================================================");
        System.out.println("Application ID : GITAM-" + (int)(Math.random()*9999));
        System.out.println("Student Name   : " + name);
        System.out.println("Department     : " + deptName);
        System.out.println("Course         : " + selectedCourse);
        System.out.println("Campus         : " + campus);
        System.out.printf("Annual Fees    : ₹%.2f\n", annualFees);
        System.out.println("Admission Status: PROVISIONAL GRANTED");
        System.out.println("===================================================");
        System.out.println("Confirmation email sent to: " + email);
        System.out.println("***************************************************");
    }
}
