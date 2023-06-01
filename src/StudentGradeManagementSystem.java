import java.util.*;

public class StudentGradeManagementSystem {

    ArrayList<Student> studentArrayList = new ArrayList<>();


    public String addStudent(String name, List<Integer> grades){

        Student student = new Student();
        student.setGrades(grades);
        student.setName(name);
        studentArrayList.add(student);

        return "Student Added successfully";

    }

    public void displayStudents(){
        int len = studentArrayList.size();
        for(int i=0;i<len;i++){
            System.out.println("Name: "+studentArrayList.get(i).getName()+" marks: "+studentArrayList.get(i).getGrades());
        }
    }


    public List<Integer> searchStudentByName(String name){

        //length of the studentArrayList
        int len = studentArrayList.size();


        for(int i=0;i<len;i++){
            Student student = studentArrayList.get(i);
            if(Objects.equals(student.getName(), name)){
                return student.getGrades();
            }
        }

        System.out.println("Student not found");
        return new ArrayList<>();
    }

    public Integer calculateAverageGrade(String name){
        int len = studentArrayList.size();
        int ans=0;
        int totalMarks = 0;
        int totalSubjects=0;
        List<Integer> gradeList = new ArrayList<>();
        Student student;
        int flag=0;

        for(int i=0;i<len;i++){
            student = studentArrayList.get(i);
            if(Objects.equals(student.getName(),name)){
                gradeList = student.getGrades();
                totalSubjects = gradeList.size();
                flag=1;
                break;
            }
        }

        if(flag==1){
            for(int i=0;i<totalSubjects;i++){
                totalMarks +=gradeList.get(i);
            }
            ans = totalMarks/totalSubjects;
        }
        return flag==0?0:ans;

    }

    public Integer calculateClassAverage(){
        int TotalNumberofStudents = studentArrayList.size();
        int TotalOfAllStudents =0;
        int ans =0;

        int len = studentArrayList.size();

        for(int i=0;i<len;i++){
            Student student = studentArrayList.get(i);
            List<Integer> StudentGrade = new ArrayList<>();
            StudentGrade = student.getGrades();
            int gradeSize= StudentGrade.size();
            for(int j=0;j<gradeSize;j++){
                TotalOfAllStudents += StudentGrade.get(i);
            }
        }

        ans = TotalOfAllStudents/TotalNumberofStudents;

        return ans;
    }

    public String removeStudent(String name){
        int len = studentArrayList.size();

        for(int i=0;i<len;i++){
            Student student = studentArrayList.get(i);
            if(Objects.equals(student.getName(),name)){
                studentArrayList.remove(i);
                break;
            }
        }

        return "Student removed From DB";
    }

    public static void main(String[] args) {

        StudentGradeManagementSystem studentGradeManagementSystem = new StudentGradeManagementSystem();
        Scanner s = new Scanner(System.in);
        String promt = "choose from options below";
        String options = "1 - addStudent, 2 - displayStudents, 3 - searchStudentByName, \n" +
                "4 - calculateAverageGrade, 5 - calculateClassAverage, 6-removeStudent, 7 - Exit";
        System.out.println(promt);
        System.out.println(options);
        int ChoosedOption = s.nextInt();
        if(ChoosedOption<=0 || ChoosedOption>7){
            System.out.println("Please Select Valid option");
        }else{
            if(ChoosedOption==1){
                String name="";
                int noGrades =0;
                List<Integer> grades = new ArrayList<>();
                System.out.println("Enter the name:");
                name = s.nextLine();
                System.out.println("total number of grades: ");
                noGrades = s.nextInt();
                System.out.println("Enter the grades: ");
                for(int i=0;i<noGrades;i++){
                    int mark = s.nextInt();
                    grades.add(mark);
                }
                studentGradeManagementSystem.addStudent(name,grades);
                System.out.println("Student added successfully");
            }else if(ChoosedOption==2){
                studentGradeManagementSystem.displayStudents();
            }else if(ChoosedOption==3){
                System.out.println("Enter the name: ");
                String name="";
                name= s.nextLine();
                studentGradeManagementSystem.searchStudentByName(name);
            }else if(ChoosedOption==4){
                System.out.println("Enter the name");
                String name ="";
                name = s.nextLine();
                studentGradeManagementSystem.calculateAverageGrade(name);
            }else if(ChoosedOption==5){
                System.out.println("Class average is: ");
                studentGradeManagementSystem.calculateClassAverage();
            }else if(ChoosedOption==6){
                System.out.println("Enter the name: ");
                String name ="";
                name = s.nextLine();
                studentGradeManagementSystem.removeStudent(name);
            }else if(ChoosedOption==7){
                System.out.println("bye");
            }
        }
    }


}
