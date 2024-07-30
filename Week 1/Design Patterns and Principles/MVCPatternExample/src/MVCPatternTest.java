public class MVCPatternTest {
    public static void main(String[] args) {
        // initial student record
        Student model = new Student("Keerthi", "44", "O");

        // view to display student details on console
        StudentView view = new StudentView();

        // controller
        StudentController controller = new StudentController(model, view);

        // Displaying initial student details
        controller.updateView();

        // Updating student details with user input
        controller.updateStudentDetails();

        // Displaying updated student details
        controller.updateView();
    }
}
