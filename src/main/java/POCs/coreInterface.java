package POCs;

public interface coreInterface {
    public static final int cnts=100;

    public static String getData(){
        return "Core Interface data";
    }

    default int getResult(){
        return 0;
    }

    String getInfo();
}
