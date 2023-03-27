import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PairTuteeForm extends JFrame {
    private JPanel panel;
    private JTextField tuteeBeingPaired;
    private JButton pairTuteeButton;
    private static List<Tutor> listOfTutors;
    private static List<Tutee> listOfTutees;

    public PairTuteeForm (List<Tutor> listOfTutors, List<Tutee> listOfTutees) {
        PairTuteeForm.listOfTutors = listOfTutors;
        PairTuteeForm.listOfTutees = listOfTutees;
        setContentPane(panel);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pairTuteeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String tuteeName = tuteeBeingPaired.getText();
                String tuteeEmailAddress = "";
                String tuteeGrade = "";
                String tuteeSubject = "";
                String tuteeQuarter = "";
                boolean notFound = true;
                while (notFound) {
                    for (Tutee listOfTutee : listOfTutees) {
                        int compareTutees = tuteeName.compareTo(listOfTutee.getName());
                        if (compareTutees == 0) {
                            tuteeEmailAddress = listOfTutee.getSchoolEmailAddress();
                            tuteeGrade = listOfTutee.getGrade();
                            tuteeSubject = listOfTutee.getSubject();
                            tuteeQuarter = listOfTutee.getQuarterForTutoring();
                            notFound = false;
                        }
                    }
                }
                boolean findPerfectTutor = false; //Remember to set findPerfectTutor to true after finding the best tutor
                int sum = 0;
                String commonCategories = "";
                while (!findPerfectTutor) {
                    for (int i = 0; i < listOfTutors.size(); i++) {
                        if (tuteeGrade.toLowerCase().compareTo(listOfTutees.get(i).getGrade().toLowerCase()) == 0) {
                            sum += 1;
                        }
                        if (tuteeSubject.toLowerCase().compareTo(listOfTutees.get(i).getSubject().toLowerCase()) == 0) {
                            sum += 1;
                        }
                        if (tuteeQuarter.toLowerCase().compareTo(listOfTutees.get(i).getQuarterForTutoring().toLowerCase()) == 0) {
                            sum += 1;
                        }
                        listOfTutors.get(i).setSum(sum);
                    }


                }
                // TODO After finding the person who matches the most, if more than one, pick one of the tutors and print that tutor, its contact information, the tutee, its contact information, and the common categories
                // TODO Store the before string somewhere and delete the paired tutee and tutor from the list
                // TODO Find a way to display all of said information on the GUI
            }
        });
    }

    public static void main(String[] args) {
        PairTuteeForm pairTuteeForm = new PairTuteeForm(listOfTutors, listOfTutees);
    }
}
