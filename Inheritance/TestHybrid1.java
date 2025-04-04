class UniversityMember {
    void login() {
        System.out.println("University member logged in");
    }
}

class Student extends UniversityMember {
    void attendClass() {
        System.out.println("Student attending class");
    }
}

class Professor extends UniversityMember {
    void teachCourse() {
        System.out.println("Professor teaching course");
    }
}

class ResearchProfessor extends Professor {
    void conductResearch() {
        System.out.println("Conducting advanced research");
    }
}

class TestHybrid1 {
    public static void main(String[] args) {
        Student s = new Student();
        ResearchProfessor rp = new ResearchProfessor();
        s.login();
        s.attendClass();
        rp.login();
        rp.teachCourse();
        rp.conductResearch();
    }
}
