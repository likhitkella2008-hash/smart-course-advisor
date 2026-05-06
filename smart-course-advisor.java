    // SAVE AS: AdvancedSmartCourseAdvisor.java

    import javax.swing.*;
    import java.awt.*;
    import java.util.HashMap;

    public class AdvancedSmartCourseAdvisor extends JFrame {

        CardLayout cardLayout;
        JPanel mainPanel;

        JComboBox<String> streamBox;
        JComboBox<String> semesterBox;
        JComboBox<String> subjectBox;

        JTextArea outputArea;

        HashMap<String, String[]> streamSemesters = new HashMap<>();
        HashMap<String, String[]> semesterSubjects = new HashMap<>();
        HashMap<String, String[]> prerequisiteGraph = new HashMap<>();
        HashMap<String, String> studyResources = new HashMap<>();

        public AdvancedSmartCourseAdvisor() {

            initializeData();

            setTitle("Academic Roadmap System");

            setSize(1600, 1000);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLocationRelativeTo(null);

            cardLayout = new CardLayout();

            mainPanel = new JPanel(cardLayout);

            mainPanel.add(createStreamPage(), "stream");
            mainPanel.add(createSemesterPage(), "semester");
            mainPanel.add(createSubjectPage(), "subject");
            mainPanel.add(createAnalysisPage(), "analysis");

            add(mainPanel);

            cardLayout.show(mainPanel, "stream");

            setVisible(true);
        }

        // =====================================================
        // DATA
        // =====================================================

        public void initializeData() {

            // STREAMS

            streamSemesters.put("MPC Engineering",
                    new String[]{
                            "Semester 1",
                            "Semester 2",
                            "Semester 3",
                            "Semester 4"
                    });

            streamSemesters.put("BIPC Medical",
                    new String[]{
                            "BIPC Semester 1",
                            "BIPC Semester 2",
                            "BIPC Semester 3",
                            "BIPC Semester 4"
                    });

            streamSemesters.put("PG Specializations",
                    new String[]{
                            "PG Courses"
                    });

            // =====================================================
            // MPC SUBJECTS
            // =====================================================

            semesterSubjects.put("Semester 1",
                    new String[]{
                            "Programming in C",
                            "Engineering Mathematics",
                            "Engineering Physics",
                            "Digital Electronics"
                    });

            semesterSubjects.put("Semester 2",
                    new String[]{
                            "Data Structures",
                            "Python Programming",
                            "Mathematics 2"
                    });

            semesterSubjects.put("Semester 3",
                    new String[]{
                            "Java Programming",
                            "DBMS",
                            "Operating Systems"
                    });

            semesterSubjects.put("Semester 4",
                    new String[]{
                            "Machine Learning",
                            "Artificial Intelligence",
                            "Cyber Security"
                    });

            // =====================================================
            // BIPC SUBJECTS
            // =====================================================

            semesterSubjects.put("BIPC Semester 1",
                    new String[]{
                            "Human Anatomy",
                            "Human Physiology",
                            "Biochemistry"
                    });

            semesterSubjects.put("BIPC Semester 2",
                    new String[]{
                            "Pathology",
                            "Microbiology",
                            "Pharmacology"
                    });

            semesterSubjects.put("BIPC Semester 3",
                    new String[]{
                            "Immunology",
                            "Molecular Biology",
                            "Genetics"
                    });

            semesterSubjects.put("BIPC Semester 4",
                    new String[]{
                            "Bioinformatics",
                            "Medical Research",
                            "Diagnostic Techniques"
                    });

            // =====================================================
            // PG SUBJECTS
            // =====================================================

            semesterSubjects.put("PG Courses",
                    new String[]{
                            "Data Science",
                            "Artificial Intelligence",
                            "Cyber Security",
                            "Cardiology",
                            "Neurology",
                            "Radiology"
                    });

            // =====================================================
            // PREREQUISITES
            // =====================================================

            prerequisiteGraph.put("Programming in C",
                    new String[]{
                            "Computer Basics",
                            "Flowcharts",
                            "Logic Building"
                    });

            prerequisiteGraph.put("Engineering Mathematics",
                    new String[]{
                            "Algebra",
                            "Trigonometry",
                            "Basic Calculus"
                    });

            prerequisiteGraph.put("Engineering Physics",
                    new String[]{
                            "Basic Physics",
                            "Motion",
                            "Force and Energy"
                    });

            prerequisiteGraph.put("Digital Electronics",
                    new String[]{
                            "Binary Numbers",
                            "Logic Gates",
                            "Boolean Algebra"
                    });

            prerequisiteGraph.put("Data Structures",
                    new String[]{
                            "Programming in C",
                            "Arrays",
                            "Pointers"
                    });

            prerequisiteGraph.put("Python Programming",
                    new String[]{
                            "Programming Basics",
                            "Algorithms",
                            "Problem Solving"
                    });

            prerequisiteGraph.put("Mathematics 2",
                    new String[]{
                            "Engineering Mathematics",
                            "Matrices",
                            "Calculus"
                    });

            prerequisiteGraph.put("Java Programming",
                    new String[]{
                            "Programming in C",
                            "OOPS Concepts",
                            "Data Structures"
                    });

            prerequisiteGraph.put("DBMS",
                    new String[]{
                            "SQL Basics",
                            "ER Diagrams",
                            "Normalization"
                    });

            prerequisiteGraph.put("Operating Systems",
                    new String[]{
                            "Computer Organization",
                            "Memory",
                            "Processes"
                    });

            prerequisiteGraph.put("Machine Learning",
                    new String[]{
                            "Python Programming",
                            "Statistics",
                            "Linear Algebra"
                    });

            // =====================================================
            // PG PREREQUISITES
            // =====================================================

            prerequisiteGraph.put("Artificial Intelligence",
                    new String[]{
                            "Machine Learning",
                            "Algorithms",
                            "Neural Networks",
                            "Python Programming"
                    });

            prerequisiteGraph.put("Cyber Security",
                    new String[]{
                            "Computer Networks",
                            "Cryptography",
                            "Operating Systems",
                            "Network Security"
                    });

            prerequisiteGraph.put("Data Science",
                    new String[]{
                            "Python Programming",
                            "Statistics",
                            "Machine Learning",
                            "Linear Algebra",
                            "DBMS"
                    });

            prerequisiteGraph.put("Cardiology",
                    new String[]{
                            "Human Anatomy",
                            "Human Physiology",
                            "Blood Circulation",
                            "Heart Structure"
                    });

            prerequisiteGraph.put("Neurology",
                    new String[]{
                            "Brain Anatomy",
                            "Nervous System",
                            "Human Physiology",
                            "Neurobiology"
                    });

            prerequisiteGraph.put("Radiology",
                    new String[]{
                            "Physics",
                            "Human Anatomy",
                            "Medical Imaging",
                            "Diagnostic Techniques"
                    });

            // =====================================================
            // BIPC PREREQUISITES
            // =====================================================

            prerequisiteGraph.put("Human Anatomy",
                    new String[]{
                            "Cells",
                            "Tissues",
                            "Body Structure"
                    });

            prerequisiteGraph.put("Human Physiology",
                    new String[]{
                            "Human Anatomy",
                            "Body Systems",
                            "Organs"
                    });

            prerequisiteGraph.put("Biochemistry",
                    new String[]{
                            "Organic Chemistry",
                            "Biomolecules",
                            "Cell Biology"
                    });

            prerequisiteGraph.put("Pathology",
                    new String[]{
                            "Human Anatomy",
                            "Human Physiology",
                            "Microbiology"
                    });

            prerequisiteGraph.put("Microbiology",
                    new String[]{
                            "Cell Biology",
                            "Biochemistry",
                            "Bacteria"
                    });

            prerequisiteGraph.put("Pharmacology",
                    new String[]{
                            "Biochemistry",
                            "Human Physiology",
                            "Pathology"
                    });

            prerequisiteGraph.put("Immunology",
                    new String[]{
                            "Microbiology",
                            "Blood Cells",
                            "Immune System"
                    });

            prerequisiteGraph.put("Molecular Biology",
                    new String[]{
                            "DNA",
                            "RNA",
                            "Cell Biology"
                    });

            prerequisiteGraph.put("Genetics",
                    new String[]{
                            "Genes",
                            "DNA",
                            "Chromosomes"
                    });

            prerequisiteGraph.put("Bioinformatics",
                    new String[]{
                            "Biology",
                            "Computer Basics",
                            "Genetics"
                    });

            prerequisiteGraph.put("Medical Research",
                    new String[]{
                            "Research Methods",
                            "Biostatistics",
                            "Pathology"
                    });

            prerequisiteGraph.put("Diagnostic Techniques",
                    new String[]{
                            "Human Anatomy",
                            "Radiology Basics",
                            "Pathology"
                    });

            // =====================================================
            // STUDY TOPICS
            // =====================================================

            studyResources.put("Programming in C",
                    "1. Variables\n"
                            + "2. Loops\n"
                            + "3. Functions\n"
                            + "4. Arrays\n"
                            + "5. Pointers");

            studyResources.put("Engineering Mathematics",
                    "1. Algebra\n"
                            + "2. Trigonometry\n"
                            + "3. Calculus\n"
                            + "4. Matrices");

            studyResources.put("Engineering Physics",
                    "1. Mechanics\n"
                            + "2. Waves\n"
                            + "3. Optics\n"
                            + "4. Modern Physics");

            studyResources.put("Digital Electronics",
                    "1. Binary Numbers\n"
                            + "2. Logic Gates\n"
                            + "3. Boolean Algebra\n"
                            + "4. Flip Flops");

            studyResources.put("Data Structures",
                    "1. Arrays\n"
                            + "2. Linked Lists\n"
                            + "3. Stacks\n"
                            + "4. Queues");

            studyResources.put("Python Programming",
                    "1. Variables\n"
                            + "2. Functions\n"
                            + "3. Lists\n"
                            + "4. OOPS");

            studyResources.put("Java Programming",
                    "1. Classes\n"
                            + "2. Objects\n"
                            + "3. Inheritance\n"
                            + "4. Exception Handling");

            studyResources.put("DBMS",
                    "1. ER Diagrams\n"
                            + "2. SQL\n"
                            + "3. Normalization\n"
                            + "4. Joins");

            studyResources.put("Operating Systems",
                    "1. Processes\n"
                            + "2. Threads\n"
                            + "3. Scheduling\n"
                            + "4. Deadlocks");

            studyResources.put("Machine Learning",
                    "1. Regression\n"
                            + "2. Classification\n"
                            + "3. Neural Networks");

            // =====================================================
            // PG STUDY TOPICS
            // =====================================================

            studyResources.put("Artificial Intelligence",
                    "1. Search Algorithms\n"
                            + "2. Neural Networks\n"
                            + "3. Deep Learning\n"
                            + "4. NLP\n"
                            + "5. AI Applications");

            studyResources.put("Cyber Security",
                    "1. Cryptography\n"
                            + "2. Ethical Hacking\n"
                            + "3. Malware Analysis\n"
                            + "4. Network Security");

            studyResources.put("Data Science",
                    "1. Python Libraries\n"
                            + "2. Statistics\n"
                            + "3. Data Cleaning\n"
                            + "4. Machine Learning\n"
                            + "5. Big Data");

            studyResources.put("Cardiology",
                    "1. Heart Anatomy\n"
                            + "2. ECG Analysis\n"
                            + "3. Cardiac Diseases\n"
                            + "4. Blood Circulation");

            studyResources.put("Neurology",
                    "1. Brain Structure\n"
                            + "2. Nervous System\n"
                            + "3. Brain Disorders\n"
                            + "4. Neurophysiology");

            studyResources.put("Radiology",
                    "1. X-Ray\n"
                            + "2. MRI\n"
                            + "3. CT Scan\n"
                            + "4. Medical Imaging");

            // =====================================================
            // BIPC STUDY TOPICS
            // =====================================================

            studyResources.put("Human Anatomy",
                    "1. Skeletal System\n"
                            + "2. Muscular System\n"
                            + "3. Nervous System");

            studyResources.put("Human Physiology",
                    "1. Blood Circulation\n"
                            + "2. Respiration\n"
                            + "3. Digestion");

            studyResources.put("Biochemistry",
                    "1. Proteins\n"
                            + "2. Enzymes\n"
                            + "3. Metabolism");

            studyResources.put("Pathology",
                    "1. Cell Injury\n"
                            + "2. Inflammation\n"
                            + "3. Blood Disorders");

            studyResources.put("Microbiology",
                    "1. Bacteria\n"
                            + "2. Viruses\n"
                            + "3. Fungi");

            studyResources.put("Pharmacology",
                    "1. Drug Actions\n"
                            + "2. Antibiotics\n"
                            + "3. Pharmacokinetics");

            studyResources.put("Immunology",
                    "1. Antigens\n"
                            + "2. Antibodies\n"
                            + "3. Vaccines");

            studyResources.put("Molecular Biology",
                    "1. DNA Structure\n"
                            + "2. Replication\n"
                            + "3. Translation");

            studyResources.put("Genetics",
                    "1. Genes\n"
                            + "2. Chromosomes\n"
                            + "3. Mutations");

            studyResources.put("Bioinformatics",
                    "1. Genomics\n"
                            + "2. Proteomics\n"
                            + "3. Computational Biology");

            studyResources.put("Medical Research",
                    "1. Clinical Trials\n"
                            + "2. Data Collection\n"
                            + "3. Medical Statistics");

            studyResources.put("Diagnostic Techniques",
                    "1. MRI\n"
                            + "2. CT Scan\n"
                            + "3. X-Ray");
        }

        // =====================================================
        // DESIGN
        // =====================================================

        public JPanel darkPanel() {

            JPanel panel = new JPanel();

            panel.setBackground(new Color(2, 6, 23));

            return panel;
        }

        public JButton createButton(String text) {

            JButton button = new JButton(text);

            button.setFont(new Font("Arial",
                    Font.BOLD, 22));

            button.setBackground(
                    new Color(59, 130, 246));

            button.setForeground(Color.WHITE);

            return button;
        }

        // =====================================================
        // STREAM PAGE
        // =====================================================

        public JPanel createStreamPage() {

            JPanel panel = darkPanel();

            panel.setLayout(null);

            JLabel heading =
                    new JLabel("Academic Roadmap System");

            heading.setForeground(Color.WHITE);

            heading.setFont(new Font("Arial",
                    Font.BOLD, 42));

            heading.setBounds(420, 100, 700, 60);

            panel.add(heading);

            JLabel label =
                    new JLabel("Select Stream");

            label.setForeground(Color.WHITE);

            label.setFont(new Font("Arial",
                    Font.BOLD, 28));

            label.setBounds(500, 250, 300, 40);

            panel.add(label);

            streamBox = new JComboBox<>(
                    new String[]{
                            "MPC Engineering",
                            "BIPC Medical",
                            "PG Specializations"
                    });

            streamBox.setFont(
                    new Font("Arial",
                            Font.PLAIN, 24));

            streamBox.setBounds(500, 320, 600, 50);

            panel.add(streamBox);

            JButton nextButton =
                    createButton("Next");

            nextButton.setBounds(500, 450, 600, 60);

            nextButton.addActionListener(e -> {

                loadSemesters();

                cardLayout.show(mainPanel,
                        "semester");
            });

            panel.add(nextButton);

            return panel;
        }

        // =====================================================
        // SEMESTER PAGE
        // =====================================================

        public JPanel createSemesterPage() {

            JPanel panel = darkPanel();

            panel.setLayout(null);

            JLabel heading =
                    new JLabel("Select Semester");

            heading.setForeground(Color.WHITE);

            heading.setFont(new Font("Arial",
                    Font.BOLD, 40));

            heading.setBounds(500, 100, 500, 60);

            panel.add(heading);

            semesterBox = new JComboBox<>();

            semesterBox.setFont(new Font("Arial",
                    Font.PLAIN, 24));

            semesterBox.setBounds(450, 300, 650, 50);

            panel.add(semesterBox);

            JButton nextButton =
                    createButton("Next");

            nextButton.setBounds(450, 450, 650, 60);

            nextButton.addActionListener(e -> {

                loadSubjects();

                cardLayout.show(mainPanel,
                        "subject");
            });

            panel.add(nextButton);

            JButton backButton =
                    createButton("← Back");

            backButton.setBounds(450, 550, 650, 60);

            backButton.addActionListener(e -> {

                cardLayout.show(mainPanel,
                        "stream");
            });

            panel.add(backButton);

            return panel;
        }

        // =====================================================
        // SUBJECT PAGE
        // =====================================================

        public JPanel createSubjectPage() {

            JPanel panel = darkPanel();

            panel.setLayout(null);

            JLabel heading =
                    new JLabel("Select Subject");

            heading.setForeground(Color.WHITE);

            heading.setFont(new Font("Arial",
                    Font.BOLD, 40));

            heading.setBounds(500, 100, 500, 60);

            panel.add(heading);

            subjectBox = new JComboBox<>();

            subjectBox.setFont(new Font("Arial",
                    Font.PLAIN, 24));

            subjectBox.setBounds(450, 300, 650, 50);

            panel.add(subjectBox);

            JButton analyzeButton =
                    createButton("Analyze Subject");

            analyzeButton.setBounds(450, 450, 650, 60);

            analyzeButton.addActionListener(e -> {

                showAnalysis();

                cardLayout.show(mainPanel,
                        "analysis");
            });

            panel.add(analyzeButton);

            JButton backButton =
                    createButton("← Back");

            backButton.setBounds(450, 550, 650, 60);

            backButton.addActionListener(e -> {

                cardLayout.show(mainPanel,
                        "semester");
            });

            panel.add(backButton);

            return panel;
        }

        // =====================================================
        // ANALYSIS PAGE
        // =====================================================

        public JPanel createAnalysisPage() {

            JPanel panel = darkPanel();

            panel.setLayout(new BorderLayout());

            JLabel heading =
                    new JLabel("Subject Analysis",
                            SwingConstants.CENTER);

            heading.setForeground(Color.WHITE);

            heading.setFont(new Font("Arial",
                    Font.BOLD, 40));

            panel.add(heading,
                    BorderLayout.NORTH);

            outputArea = new JTextArea();

            outputArea.setEditable(false);

            outputArea.setBackground(
                    new Color(30, 41, 59));

            outputArea.setForeground(Color.WHITE);

            outputArea.setFont(
                    new Font("Monospaced",
                            Font.PLAIN, 22));

            panel.add(new JScrollPane(outputArea),
                    BorderLayout.CENTER);

            JButton backButton =
                    createButton("← Back");

            backButton.addActionListener(e -> {

                cardLayout.show(mainPanel,
                        "subject");
            });

            panel.add(backButton,
                    BorderLayout.SOUTH);

            return panel;
        }

        // =====================================================
        // LOAD SEMESTERS
        // =====================================================

        public void loadSemesters() {

            String selectedStream =
                    (String) streamBox.getSelectedItem();

            semesterBox.removeAllItems();

            String[] semesters =
                    streamSemesters.get(selectedStream);

            if (semesters != null) {

                for (String sem : semesters) {

                    semesterBox.addItem(sem);
                }
            }
        }

        // =====================================================
        // LOAD SUBJECTS
        // =====================================================

        public void loadSubjects() {

            String selectedSemester =
                    (String) semesterBox.getSelectedItem();

            subjectBox.removeAllItems();

            String[] subjects =
                    semesterSubjects.get(selectedSemester);

            if (subjects != null) {

                for (String sub : subjects) {

                    subjectBox.addItem(sub);
                }
            }
        }

        // =====================================================
        // SHOW ANALYSIS
        // =====================================================

        public void showAnalysis() {

            String subject =
                    (String) subjectBox.getSelectedItem();

            StringBuilder sb =
                    new StringBuilder();

            sb.append("====================================\n");
            sb.append("        SUBJECT ANALYSIS\n");
            sb.append("====================================\n\n");

            sb.append("Selected Subject : ")
                    .append(subject)
                    .append("\n\n");

            sb.append("Prerequisite Subjects:\n\n");

            String[] prereq =
                    prerequisiteGraph.get(subject);

            if (prereq != null && prereq.length > 0) {

                for (int i = 0; i < prereq.length; i++) {

                    sb.append(i + 1)
                            .append(". ")
                            .append(prereq[i])
                            .append("\n");
                }

            } else {

                sb.append("No prerequisite subjects available.\n");
            }

            sb.append("\n====================================\n");
            sb.append("Topics/Subtopics To Study:\n\n");

            String topics =
                    studyResources.get(subject);

            if (topics != null) {

                sb.append(topics);

            } else {

                sb.append("No topics available.");
            }

            outputArea.setText(sb.toString());
        }

        // =====================================================
        // MAIN
        // =====================================================

        public static void main(String[] args) {

            SwingUtilities.invokeLater(() -> {

                new AdvancedSmartCourseAdvisor();
            });
        }
    }

