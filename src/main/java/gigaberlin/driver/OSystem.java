package gigaberlin.driver;

public enum OSystem {
    Windows("Windows");

    private String OS;

    OSystem(String oSystem) {
        this.OS = oSystem;
    }

    public String getOS() {
        return OS;
    }

    //TODO: for crossBrowser Parametrized Test
}
