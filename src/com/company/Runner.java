package com.company;

public class Runner extends Thread {
    private Runner after;
    private Runner before;

    public Runner(String name) {
        super(name);
    }

    public void setRunners(Runner before, Runner after) {
        // setter dlya dvuh polei
        this.after = after;
        this.before = before;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " берет палочку");

            if (getName() == "Runner5") {
                System.out.println(getName() + " бежит к финишу");
                sleep(500);
            } else {
                System.out.println(getName() + " бежит к " + after.getName());
                sleep(500);
                after.start();
                after.join();
            }

            if (getName() != "Runner1") {
                System.out.println(getName() + " бежит к " + before.getName());
                sleep(500);
                System.out.println(before.getName() + " берет палочку");
            }

        } catch (Exception ignore) {
        }
    }
}
