import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int priority;
    int completionTime;

    public Process(int processId, int arrivalTime, int burstTime, int priority) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.completionTime = 0;
    }
}

public class ProcessScheduler {

    private static Process[] processes = new Process[10];
    private static int numProcesses = 0;

    private static JTextField burstEntry;
    private static JTextField arrivalEntry;
    private static JTextField priorityEntry;

    public static void main(String[] args) {
        // Initialize the GUI
        JFrame frame = new JFrame("Process Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Enter Process Arrival Time, Burst Time, and Priority:"));

        panel.add(new JLabel("Burst Time:"));
        burstEntry = new JTextField();
        panel.add(burstEntry);

        panel.add(new JLabel("Arrival Time:"));
        arrivalEntry = new JTextField();
        panel.add(arrivalEntry);

        panel.add(new JLabel("Priority:"));
        priorityEntry = new JTextField();
        panel.add(priorityEntry);

        JButton addProcessButton = new JButton("Add Process");
        addProcessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProcess();
            }
        });
        panel.add(addProcessButton);

        JButton resetButton = new JButton("Reset Processes");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetProcesses();
            }
        });
        panel.add(resetButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));

        buttonPanel.add(createScheduleButton("Run SJN", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sjnSchedule();
            }
        }));

        buttonPanel.add(createScheduleButton("Run FCFS", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fcfsSchedule();
            }
        }));

        buttonPanel.add(createScheduleButton("Run Priority", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prioritySchedule();
            }
        }));

        buttonPanel.add(createScheduleButton("Run LJF", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ljfSchedule();
            }
        }));

        buttonPanel.add(createScheduleButton("Run Lottery", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lotterySchedule();
            }
        }));

        buttonPanel.add(createScheduleButton("Run Round Robin", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                roundRobinSchedule(1);  // Assuming time quantum is 1
            }
        }));

        panel.add(buttonPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JButton createScheduleButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    private static void addProcess() {
        int burstTime = Integer.parseInt(burstEntry.getText());
        int arrivalTime = Integer.parseInt(arrivalEntry.getText());
        int priority = Integer.parseInt(priorityEntry.getText());

        Process newProcess = new Process(numProcesses + 1, arrivalTime, burstTime, priority);
        processes[numProcesses++] = newProcess;

        JOptionPane.showMessageDialog(null, String.format("Process ID: %d\nArrival Time: %d\nBurst Time: %d\nPriority: %d",
                newProcess.processId, newProcess.arrivalTime, newProcess.burstTime, newProcess.priority));
    }

    private static void resetProcesses() {
        numProcesses = 0;
        processes = new Process[10];
        JOptionPane.showMessageDialog(null, "Processes have been reset.");
    }

    private static void displaySchedulingResult(String result) {
        StringBuilder resultMessage = new StringBuilder(result + "\n\nScheduling Order:\n");

        for (int i = 0; i < numProcesses; i++) {
            resultMessage.append(String.format("Process ID: %d, Completion Time: %d\n", processes[i].processId, processes[i].completionTime));
        }

        JOptionPane.showMessageDialog(null, resultMessage.toString());

        resetProcesses();
    }

    private static void sortByBurstTime() {
        Arrays.sort(processes, 0, numProcesses, (p1, p2) -> Integer.compare(p1.burstTime, p2.burstTime));
    }

    private static void sjnSchedule() {
        sortByBurstTime();
        int currentTime = 0;
        int completed = 0;

        while (completed < numProcesses) {
            int nextProcess = -1;
            int minBurstTime = Integer.MAX_VALUE;

            for (int i = 0; i < numProcesses; i++) {
                if (processes[i].arrivalTime <= currentTime && processes[i].completionTime == 0) {
                    if (processes[i].burstTime < minBurstTime) {
                        minBurstTime = processes[i].burstTime;
                        nextProcess = i;
                    }
                }
            }

            if (nextProcess != -1) {
                processes[nextProcess].completionTime = currentTime + processes[nextProcess].burstTime;
                currentTime = processes[nextProcess].completionTime;
                completed++;
            } else {
                currentTime++;
            }
        }

        displaySchedulingResult("SJN Scheduling Complete");
    }

    private static void fcfsSchedule() {
        int currentTime = 0;
        int completed = 0;

        while (completed < numProcesses) {
            int nextProcess = -1;

            for (int i = 0; i < numProcesses; i++) {
                if (processes[i].arrivalTime <= currentTime && processes[i].completionTime == 0) {
                    nextProcess = i;
                    break;
                }
            }

            if (nextProcess != -1) {
                processes[nextProcess].completionTime = currentTime + processes[nextProcess].burstTime;
                currentTime = processes[nextProcess].completionTime;
                completed++;
            } else {
                currentTime++;
            }
        }

        displaySchedulingResult("FCFS Scheduling Complete");
    }

    private static void prioritySchedule() {
        int currentTime = 0;
        int completed = 0;

        while (completed < numProcesses) {
            int nextProcess = -1;
            int maxPriority = Integer.MIN_VALUE;

            for (int i = 0; i < numProcesses; i++) {
                if (processes[i].arrivalTime <= currentTime && processes[i].completionTime == 0) {
                    if (processes[i].priority > maxPriority) {
                        maxPriority = processes[i].priority;
                        nextProcess = i;
                    }
                }
            }

            if (nextProcess != -1) {
                processes[nextProcess].completionTime = currentTime + processes[nextProcess].burstTime;
                currentTime = processes[nextProcess].completionTime;
                completed++;
            } else {
                currentTime++;
            }
        }

        displaySchedulingResult("Priority Scheduling Complete");
    }

    private static void ljfSchedule() {
        int currentTime = 0;
        int completed = 0;

        while (completed < numProcesses) {
            int nextProcess = -1;
            int maxBurstTime = Integer.MIN_VALUE;

            for (int i = 0; i < numProcesses; i++) {
                if (processes[i].arrivalTime <= currentTime && processes[i].completionTime == 0) {
                    if (processes[i].burstTime > maxBurstTime) {
                        maxBurstTime = processes[i].burstTime;
                        nextProcess = i;
                    }
                }
            }

            if (nextProcess != -1) {
                processes[nextProcess].completionTime = currentTime + processes[nextProcess].burstTime;
                currentTime = processes[nextProcess].completionTime;
                completed++;
            } else {
                currentTime++;
            }
        }

        displaySchedulingResult("LJF Scheduling Complete");
    }

    private static void lotterySchedule() {
        int totalTickets = 0;

        for (int i = 0; i < numProcesses; i++) {
            totalTickets += processes[i].priority;
        }

        Random rand = new Random();
        int winningTicket = rand.nextInt(totalTickets);

        int currentTickets = 0;
        int selectedProcess = -1;

        for (int i = 0; i < numProcesses; i++) {
            currentTickets += processes[i].priority;
            if (winningTicket < currentTickets) {
                selectedProcess = i;
                break;
            }
        }

        if (selectedProcess != -1) {
            processes[selectedProcess].completionTime = processes[selectedProcess].burstTime;
            displaySchedulingResult("Lottery Scheduling Complete");
        } else {
            JOptionPane.showMessageDialog(null, "No process selected.");
        }

        resetProcesses();
    }

    private static void roundRobinSchedule(int timeQuantum) {
        int currentTime = 0;
        int[] remainingBurst = new int[10];
        for (int i = 0; i < numProcesses; i++) {
            remainingBurst[i] = processes[i].burstTime;
        }

        boolean allCompleted = false;
        while (!allCompleted) {
            allCompleted = true;
            for (int i = 0; i < numProcesses; i++) {
                if (remainingBurst[i] > 0) {
                    allCompleted = false;
                    if (remainingBurst[i] > timeQuantum) {
                        currentTime += timeQuantum;
                        remainingBurst[i] -= timeQuantum;
                    } else {
                        currentTime += remainingBurst[i];
                        processes[i].completionTime = currentTime;
                        remainingBurst[i] = 0;
                    }
                }
            }
        }

        displaySchedulingResult("Round Robin Scheduling Complete");
    }
}
