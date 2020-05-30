import java.io.Serializable;

public class Student extends Person implements Examination, Comparable<Student>, Serializable {

    private int mathGrade;
    private int infoGrade;
    private int phisGrade;
    private boolean admitted;
    private int average;

    public Student(String name, String surname, int mathGrade, int infoGrade, int phisGrade) {
        this.name = name;
        this.surname = surname;
        this.mathGrade = mathGrade;
        this.infoGrade = infoGrade;
        this.phisGrade = phisGrade;
    }

    public Student() {

    }

    public int getMathGrade() {
        return mathGrade;
    }

    public int getInfoGrade() {
        return infoGrade;
    }

    public int getPhisGrade() {
        return phisGrade;
    }

    public int getAverage() {
        this.average = (this.getMathGrade() + this.getInfoGrade() + this.getPhisGrade()) / 3;
        return this.average;
    }


    public void computePoliAverage() throws BadGradesException, WrongGradesException {
        int average = ((this.mathGrade + this.infoGrade + this.phisGrade) / 3);
        if (average < 6) {
            throw new BadGradesException("STUDENTUL ESTE REPETENT");
        } else if (average >= 6 && average < 9) {
            this.admitted = false;
        } else if (average >= 9 && average <= 10) {
            this.admitted = true;
        } else {
            throw new WrongGradesException("NOTELE TREBUIE SA FIE CUPRINSE INTRE 1 SI 10");
        }
    }

    public void computePhisAverage() throws BadGradesException, WrongGradesException {
        int average = ((this.mathGrade + this.phisGrade) / 2);
        if (average < 6) {
            throw new BadGradesException("STUDENTUL ESTE REPETENT");
        } else if (average >= 6 && average < 9) {
            this.admitted = false;
        } else if (average >= 9 && average <= 10) {
            this.admitted = true;
        } else {
            throw new WrongGradesException("NOTELE TREBUIE SA FIE CUPRINSE INTRE 1 SI 10");
        }
    }

    public void computeInfoAverage() throws BadGradesException, WrongGradesException {
        int average = ((this.mathGrade + this.infoGrade) / 2);
        if (average < 6) {
            throw new BadGradesException("STUDENTUL ESTE REPETENT");
        } else if (average >= 6 && average < 9) {
            this.admitted = false;
        } else if (average >= 9 && average <= 10) {
            this.admitted = true;
        } else {
            throw new WrongGradesException("NOTELE TREBUIE SA FIE CUPRINSE INTRE 1 SI 10");
        }
    }

    public String getAdmitted() {
        if (!admitted) {
            return "RESPINS";
        } else {
            return "ADMIS";
        }
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }


}

