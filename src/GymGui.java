
/**
 * Write a description of class Gym_GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gym_GUI {
    protected ArrayList<GymMember> arr = new ArrayList<GymMember>();
    protected JFrame GymFrame, RegularFrame, PremiumFrame;
    protected JPanel GymPanel, RegularPanel, PremiumPanel;
    protected JTextField ID, Name, Location, Phone, Email, ReferralSource,displayMemberIdField;
    protected JButton addRegular, addPremium, addRegular2, activateBtn, 
    deactivateBtn,regularClearButton,backregularButton,DisplayButton;
    protected JRadioButton radioButton1, radioButton2, radioButton3;
    protected JComboBox<Integer> dayBox, yearBox, msdDayBox, msdYearBox;
    protected JComboBox<String> monthBox, msdMonthBox,planBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                try {
                    Gym_GUI window = new Gym_GUI();
                    window.GymFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }

    public Gym_GUI() {
        arr = new ArrayList<>();

        // Main Frame
        GymFrame = new JFrame("Gym Management System");
        GymFrame.setBounds(100, 100, 400, 200);
        GymFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GymPanel = new JPanel();
        GymPanel.setLayout(new GridLayout(1, 2, 10, 10));

        addRegular = new JButton("Add Regular Member");
        addRegular.addActionListener(new RegularButtonListener(this));

        addPremium = new JButton("Add Premium Member");
        addPremium.addActionListener(new PremiumButtonListener(this));

        GymPanel.add(addRegular);
        GymPanel.add(addPremium);
        GymFrame.getContentPane().add(GymPanel, BorderLayout.CENTER);

        // Regular Member Frame
        RegularFrame = new JFrame("Regular Member Management");
        RegularFrame.setBounds(150, 150, 600, 650);
        RegularFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        RegularPanel = new JPanel();
        RegularPanel.setLayout(null);
        RegularPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Personal Information Section
        JLabel personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setBounds(10, 10, 200, 20);
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        RegularPanel.add(personalInfoLabel);

        // ID
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 40, 80, 25);
        RegularPanel.add(idLabel);
        ID = new JTextField();
        ID.setBounds(100, 40, 120, 25);
        RegularPanel.add(ID);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(250, 40, 80, 25);
        RegularPanel.add(nameLabel);
        Name = new JTextField();
        Name.setBounds(330, 40, 200, 25);
        RegularPanel.add(Name);

        // Location
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(20, 80, 80, 25);
        RegularPanel.add(locationLabel);
        Location = new JTextField();
        Location.setBounds(100, 80, 120, 25);
        RegularPanel.add(Location);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(250, 80, 80, 25);
        RegularPanel.add(phoneLabel);
        Phone = new JTextField();
        Phone.setBounds(330, 80, 200, 25);
        RegularPanel.add(Phone);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 120, 80, 25);
        RegularPanel.add(emailLabel);
        Email = new JTextField();
        Email.setBounds(100, 120, 430, 25);
        RegularPanel.add(Email);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(20, 160, 80, 25);
        RegularPanel.add(genderLabel);

        radioButton1 = new JRadioButton("Male");
        radioButton1.setBounds(80, 160, 60, 25);
        radioButton2 = new JRadioButton("Female");
        radioButton2.setBounds(150, 160, 80, 25);
        radioButton3 = new JRadioButton("Other");
        radioButton3.setBounds(240, 160, 80, 25);

        // Plan Selection for Regular Members
        JLabel planLabel = new JLabel("Plan:");
        planLabel.setBounds(330, 160, 80, 25);
        RegularPanel.add(planLabel);

        String[] plans = {"Basic", "Standard", "Deluxe"};
        planBox = new JComboBox<>(plans);
        planBox.setBounds(390, 160, 150, 25);
        RegularPanel.add(planBox);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioButton1);
        genderGroup.add(radioButton2);
        genderGroup.add(radioButton3);

        RegularPanel.add(radioButton1);
        RegularPanel.add(radioButton2);
        RegularPanel.add(radioButton3);

        // DOB
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(20, 200, 100, 25);
        RegularPanel.add(dobLabel);

        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) 
            days[i] = i + 1;
        dayBox = new JComboBox<>(days);
        dayBox.setBounds(120, 200, 50, 25);
        RegularPanel.add(dayBox);

        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            };
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(180, 200, 100, 25);
        RegularPanel.add(monthBox);

        int currentYear = java.time.Year.now().getValue();
        Integer[] years = new Integer[currentYear - 1960 + 1];
        for (int i = 0; i < years.length; i++) 
            years[i] = 1960 + i;
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(290, 200, 80, 25);
        RegularPanel.add(yearBox);

        // Referral Source
        JLabel referralLabel = new JLabel("Referral Source:");
        referralLabel.setBounds(20, 240, 120, 25);
        RegularPanel.add(referralLabel);
        ReferralSource = new JTextField();
        ReferralSource.setBounds(140, 240, 390, 25);
        RegularPanel.add(ReferralSource);

        // Membership Start Date
        JLabel msdLabel = new JLabel("Membership Start Date:");
        msdLabel.setBounds(20, 280, 180, 25);
        RegularPanel.add(msdLabel);

        msdDayBox = new JComboBox<>(days);
        msdDayBox.setBounds(200, 280, 50, 25);
        RegularPanel.add(msdDayBox);

        msdMonthBox = new JComboBox<>(months);
        msdMonthBox.setBounds(260, 280, 100, 25);
        RegularPanel.add(msdMonthBox);

        msdYearBox = new JComboBox<>(years);
        msdYearBox.setBounds(370, 280, 80, 25);
        RegularPanel.add(msdYearBox);

        // Add Member Button
        addRegular2 = new JButton("Add Regular Member");
        addRegular2.setBounds(20, 330, 190, 30);
        addRegular2.addActionListener(e -> addRegularMember());
        RegularPanel.add(addRegular2);

        // Membership Management Section
        JLabel membershipLabel = new JLabel("Membership Management");
        membershipLabel.setBounds(10, 380, 200, 20);
        membershipLabel.setFont(new Font("Arial", Font.BOLD, 14));
        RegularPanel.add(membershipLabel);

        // Activate Membership
        JLabel activateLabel = new JLabel("Member ID:");
        activateLabel.setBounds(20, 420, 80, 25);
        RegularPanel.add(activateLabel);

        JTextField activateIdField = new JTextField();
        activateIdField.setBounds(100, 420, 100, 25);
        RegularPanel.add(activateIdField);

        activateBtn = new JButton("Activate Membership");
        activateBtn.setBounds(220, 420, 180, 25);
        activateBtn.addActionListener(e -> {
                String inputId = activateIdField.getText().trim();
                try {
                    int memberId = Integer.parseInt(inputId);
                    GymMember member = findMemberById(memberId);
                    if (member != null) {
                        member.activateMembership();
                        JOptionPane.showMessageDialog(RegularFrame, "Membership Activated for Member ID: " + memberId);
                    } else {
                        JOptionPane.showMessageDialog(RegularFrame, "Member ID not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegularFrame, "Invalid Member ID entered.");
                }
            });
        RegularPanel.add(activateBtn);

        // Deactivate Membership
        JLabel deactivateLabel = new JLabel("Member ID:");
        deactivateLabel.setBounds(20, 460, 80, 25);
        RegularPanel.add(deactivateLabel);

        JTextField deactivateIdField = new JTextField();
        deactivateIdField.setBounds(100, 460, 100, 25);
        RegularPanel.add(deactivateIdField);

        deactivateBtn = new JButton("Deactivate Membership");
        deactivateBtn.setBounds(220, 460, 180, 25);
        deactivateBtn.addActionListener(e -> {
                String inputId = deactivateIdField.getText().trim();
                try {
                    int memberId = Integer.parseInt(inputId);
                    GymMember member = findMemberById(memberId);
                    if (member != null) {
                        member.deactiveMembership();
                        JOptionPane.showMessageDialog(RegularFrame, "Membership Deactivated for Member ID: " + memberId);
                    } else {
                        JOptionPane.showMessageDialog(RegularFrame, "Member ID not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegularFrame, "Invalid Member ID entered.");
                }
            });
        RegularPanel.add(deactivateBtn);

        // Add these near your other buttons in the constructor (after the deactivate button)
        JLabel markAttendanceLabel = new JLabel("Member ID:");
        markAttendanceLabel.setBounds(20, 500, 80, 25);
        RegularPanel.add(markAttendanceLabel);

        JTextField markAttendanceIdField = new JTextField();
        markAttendanceIdField.setBounds(100, 500, 100, 25);
        RegularPanel.add(markAttendanceIdField);

        JButton markAttendanceBtn = new JButton("Mark Attendance");
        markAttendanceBtn.setBounds(220, 500, 150, 25);
        RegularPanel.add(markAttendanceBtn);

        JLabel revertMemberLabel = new JLabel("Member ID:");
        revertMemberLabel.setBounds(20, 540, 80, 25);
        RegularPanel.add(revertMemberLabel);

        JTextField revertMemberIdField = new JTextField();
        revertMemberIdField.setBounds(100, 540, 100, 25);
        RegularPanel.add(revertMemberIdField);

        JButton revertMemberBtn = new JButton("Revert Member");
        revertMemberBtn.setBounds(220, 540, 150, 25);
        RegularPanel.add(revertMemberBtn);

        // Clear Button
        regularClearButton = new JButton("Clear");
        regularClearButton.setBounds(270, 330, 95, 30);
        regularClearButton.addActionListener(e -> addRegularMember());
        RegularPanel.add(regularClearButton);
        regularClearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ID.setText("");
                    Name.setText("");
                    Location.setText("");
                    Phone.setText("");
                    Email.setText("");
                    ReferralSource.setText("");
                    planBox.setSelectedIndex(-1);  

                    radioButton1.setSelected(false);
                    radioButton2.setSelected(false);
                    radioButton3.setSelected(false);

                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    msdDayBox.setSelectedIndex(0);
                    msdMonthBox.setSelectedIndex(0);
                    msdYearBox.setSelectedIndex(0);
                }
            });

        // Back Button
        backregularButton = new JButton("Back");
        backregularButton.setBounds(380, 330, 95, 30);
        backregularButton.addActionListener(e -> addRegularMember());
        RegularPanel.add(backregularButton);
        backregularButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RegularFrame.setVisible(false);  // Hide the regular frame
                    GymFrame.setVisible(true);       // Show the main frame
                }
            });


        JLabel displayMemberLabel = new JLabel("Member ID:");
        displayMemberLabel.setBounds(20, 580, 80, 25); 
        RegularPanel.add(displayMemberLabel);

        JTextField displayMemberIdField = new JTextField();
        displayMemberIdField.setBounds(100, 580, 100, 25); 
        RegularPanel.add(displayMemberIdField);

        DisplayButton = new JButton("Display");
        DisplayButton.setBounds(220, 580, 150, 25); 
        RegularPanel.add(DisplayButton);

        DisplayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputId = displayMemberIdField.getText().trim();
                    try {
                        int memberId = Integer.parseInt(inputId);
                        GymMember member = findMemberById(memberId);

                        if (member != null && member instanceof Regular_member) {
                            Regular_member regularMember = (Regular_member) member;
                            String info = "ID: " + regularMember.get_id() + "\n" +
                                "Name: " + regularMember.get_name() + "\n" +
                                "Location: " + regularMember.get_Location() + "\n" +
                                "Phone: " + regularMember.get_Phone()+ "\n" +
                                "Email: " + regularMember.get_Gender() + "\n" +
                                "Referral Source: " + regularMember.get_referralSource() + "\n" +
                                "Gender: " + regularMember.get_Gender() + "\n" +
                                "Date of Birth: " + regularMember.get_DOB() + "\n" +
                                "Membership Start Date: " + regularMember.get_MembershipStartDate() + "\n" +
                                "Active Status: " + regularMember.get_ActiveStatus() + "\n" +
                                "Attendance: " + regularMember.get_Attendance() + "\n" +
                                "Loyalty Points: " + regularMember.get_LoyalPoints() + "\n" +
                                "Plan: " + regularMember.get_Plan(); 

                            JOptionPane.showMessageDialog(RegularFrame, info, "Regular Member Information", JOptionPane.INFORMATION_MESSAGE);
                        } else if (member != null) {
                            JOptionPane.showMessageDialog(RegularFrame, "Member with ID " + memberId + " is not a Regular Member.", "Not a Regular Member", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(RegularFrame, "Member with ID " + memberId + " not found.", "Not Found", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(RegularFrame, "Invalid Member ID format. Please enter a number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        // Mark Attendance Button Action
        markAttendanceBtn.addActionListener(e -> {
                String inputId = markAttendanceIdField.getText().trim();
                try {
                    int memberId = Integer.parseInt(inputId);
                    GymMember member = findMemberById(memberId);

                    if (member != null && member instanceof RegularMember) {
                        if (member.get_ActiveStatus()) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(RegularFrame, 
                                "Attendance marked for Regular Member ID: " + memberId +
                                "\nTotal Attendance: " + member.get_Attendance() +
                                "\nLoyalty Points: " + member.get_LoyalPoints(),
                                "Attendance Recorded", 
                                JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(RegularFrame, 
                                "Cannot mark attendance - membership is inactive",
                                "Inactive Membership", 
                                JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(RegularFrame, 
                            "Regular Member ID not found",
                            "Not Found", 
                            JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegularFrame, 
                        "Please enter a valid numeric Member ID",
                        "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
                }
            });

        // Revert Member Button Action
        revertMemberBtn.addActionListener(e -> {
                String inputId = revertMemberIdField.getText().trim();
                try {
                    int memberId = Integer.parseInt(inputId);
                    GymMember member = findMemberById(memberId);

                    if (member != null && member instanceof Regular_member) {
                        ((Regular_member)member).revertRegularMember("Admin request");
                        JOptionPane.showMessageDialog(RegularFrame, 
                            "Regular Member ID " + memberId + " has been reverted\n" +
                            "All data has been reset to default values",
                            "Member Reverted", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(RegularFrame, 
                            "Regular Member ID not found",
                            "Not Found", 
                            JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegularFrame, 
                        "Please enter a valid numeric Member ID",
                        "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
                }
            });
        RegularFrame.getContentPane().add(RegularPanel);
    }

    public Gym_member findMemberById(int id) {
        for (GymMember member : arr) {
            if (member.get_id() == id) {
                return member;
            }
        }
        return null;
    }

    public void addRegularMember() {
        try {
            int id = Integer.parseInt(this.ID.getText());
            String name = this.Name.getText();
            String location = this.Location.getText();
            String phone = this.Phone.getText();
            String email = this.Email.getText();
            String referralSource = this.ReferralSource.getText();
            String gender = this.radioButton1.isSelected() ? "Male" :
                this.radioButton2.isSelected() ? "Female" : "Other";

            int day = (Integer) dayBox.getSelectedItem();
            String month = (String) monthBox.getSelectedItem();
            int year = (Integer) yearBox.getSelectedItem();
            String DOB = day + " " + month + " " + year;

            int msdDay = (Integer) msdDayBox.getSelectedItem();
            String msdMonth = (String) msdMonthBox.getSelectedItem();
            int msdYear = (Integer) msdYearBox.getSelectedItem();
            String MembershipStartDate = msdDay + " " + msdMonth + " " + msdYear;

            Regular_member regularMember = new Regular_member(id, name, location, phone, email, 
                    referralSource, gender, DOB, MembershipStartDate);
            arr.add(regularMember);

            JOptionPane.showMessageDialog(RegularFrame, "Regular Member Added Successfully");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(RegularFrame, "Invalid input. Please check all fields.");
        }

        
    }

    public void showRegularFrame() {
        RegularFrame.setVisible(true);
    }

    public void showPremiumFrame() {
        PremiumFrame.setVisible(true);
    }

}

class RegularButtonListener implements ActionListener {
    private Gym_GUI gui;

    public RegularButtonListener(Gym_GUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.showRegularFrame();
    }
}

class PremiumButtonListener implements ActionListener {
    private Gym_GUI gui;

    public PremiumButtonListener(Gym_GUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.showPremiumFrame();
    }
}
