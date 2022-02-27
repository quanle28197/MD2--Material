public class Manager {
    Material[] materials;

    public Manager(Material[] materials) {
        this.materials = materials;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    public double getAllAmount() {
        double sumOfAmount = 0;
        for (Material m: materials) {
            sumOfAmount += m.getAmount();
        }
        return sumOfAmount;
    }

    public double getAllReal() {
        double sumOfAllReal = 0;
        for (Material m: materials) {
            sumOfAllReal += m.getRealMoney();
        }
        return sumOfAllReal;
    }

    public double getDifferent() {
        return this.getAllAmount() - this.getAllReal();
    }
}
