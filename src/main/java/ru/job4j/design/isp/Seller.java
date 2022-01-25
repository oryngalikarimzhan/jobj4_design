package ru.job4j.design.isp;

public class Seller implements WorkerDuties {
    @Override
    public void clean() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String sendMassage(String address) {
        return "hello";
    }

    @Override
    public boolean sell(Item item) {
        return true;
    }

    @Override
    public boolean participate(Meating meating) {
        return true;
    }

    @Override
    public void repair(Item item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean giveInstruction(Worker worker) {
        throw new UnsupportedOperationException();
    }
}
