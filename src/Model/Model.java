package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
    private static final List<Group> groups = new ArrayList<>();

    public boolean addGroup(String groupName) {
        for (Group gr : groups) {
            if (gr.getGroupName().equals(groupName)) {
                return false;
            }
        }
        Group group = new Group();
        group.setGroupName(groupName);
        groups.add(group);
        return true;
    }

    public boolean addStudent(String studentName, String groupName) {
        for (Group gr : groups) {
            if (gr.getGroupName().equals(groupName)) {
                Student student = new Student();
                student.setStudentName(studentName);
                gr.getStudentList().add(student);
                return true;
            }
        }
        return false;
    }


    public boolean addOrUpdateSubject(String groupName, String studentName, String subjectName, int marc) {
        for (Group gr : groups) {
            if (gr.getGroupName().equals(groupName)) {
                for (Student student : gr.getStudentList()) {
                    if (student.getStudentName().equals(studentName)) {
                        Subject subject = new Subject(subjectName);
                        student.getSubjectMarkMap().put(subject, marc);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public Set<Subject> findSubjectByStudentNameAndGroup(String studentName, String groupName) {
        for (Group gr : groups) {
            if (gr.getGroupName().equals(groupName)) {
                for (Student student : gr.getStudentList()) {
                    if (student.getStudentName().equals(studentName)) {
                        return student.getSubjectMarkMap().keySet();
                    }
                }
            }
        }
        return new HashSet<>();
    }

    public Group findGroupByStudentName(String studentName) {
        for (Group gr : groups) {
            for (Student student : gr.getStudentList()) {
                if (student.getStudentName().equals(studentName)) {
                    return gr;
                }
            }
        }
        return null;
    }

    public Set<Group> findGroupsBySubjectName(String subjectName) {
        Set<Group> groupResult = new HashSet<>();
        for (Group gr : groups) {
            for (Student student : gr.getStudentList()) {
                for (Subject subject : student.getSubjectMarkMap().keySet()) {
                    if (subjectName.equals(subject.getName())) {
                        groupResult.add(gr);
                        continue;
                    }
                }
            }
        }
        return groupResult;
    }

    public List<Student> getAllStudent(String groupName) {
        for (Group gr : groups) {
            if (gr.getGroupName().equals(groupName)) {
                return gr.getStudentList();
            }
        }
        return new ArrayList<>();
    }

    public boolean deleteGroupByGroupName(String groupName) {
        int indexToDelete = -1;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equals(groupName)) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete > -1) {
            groups.remove(indexToDelete);
            return true;
        }
        return false;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
