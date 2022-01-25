package ru.job4j.design.isp;

public interface WorkerDuties {
    void clean();
    String sendMassage(String address);
    boolean sell(Item item);
    boolean participate(Meating meating);
    void repair(Item item);
    boolean giveInstruction(Worker worker);
}
