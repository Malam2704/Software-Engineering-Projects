package assignmenttwo;

import java.util.ArrayList;
import java.util.List;

public class Task{
    // fields and constructors
    private String name;
    private int time;

    public Task(String name, int time){
        this.name = name;
        this.time = time;
    }
    
    // getters
    public String getName() {
        return name;
    }public int getTime() {
        return time;
    }


    /*Greedy Algorithm Explained:
    I take in a total allocated time, and a list of tasks, and it 
    essentially iterates over the list, checking if we have time 
    to do the next task. 

    It is greedy because it goes first come first server, if a task
    comes first it will 100% do it if there's time left, and will only
    not do a task if it takes too long and the rest of the tasks that 
    have been confirmed to been completed, combined will take more than
    the allocated time parameter.

    It is not efficient because there are many many cases where time will 
    be left over and not used for any tasks. It will not go back to analyze
    any available spots for time left over.
     */
    protected static List<Task> greedy(List<Task> myTasks, int allocatedTime){
        List<Task> soFars = new ArrayList<>();
        int soFarTime = 0;

        for(int i = 0; i < myTasks.size(); i++){
            if(myTasks.size() >= 1){
                try{
                    if(myTasks.get(i).getTime() + soFarTime <= allocatedTime){
                        soFars.add(myTasks.get(i));
                        soFarTime+=myTasks.get(i).getTime();
                    }
                }catch(IndexOutOfBoundsException j){}
            }
        }

        return soFars;
    }

    // to stirng so when we print it out doens't look weird, like the @array
    @Override
    public String toString() {
        return "(Name: " + name + ", Time: " + time + ")";
    }

    // main
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("project", 3));
        tasks.add(new Task("eat", 2));
        tasks.add(new Task("Sleep", 8));
        tasks.add(new Task("anime", 3));
        tasks.add(new Task("jog", 2));
        tasks.add(new Task("walk", 3));
        System.out.println(tasks.size());

        System.out.println(greedy(tasks, 8));
    }
}