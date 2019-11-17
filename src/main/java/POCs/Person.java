package POCs;

public abstract class Person {
    private String name;

    public Person(String pName){
        this.name=pName;
    }

    public String getName(){
        return this.name;
    }

    public abstract String getDescription();

    @Override
    public String toString(){
        return this.getClass().getName()+" name: "+this.getName();
    }



}
