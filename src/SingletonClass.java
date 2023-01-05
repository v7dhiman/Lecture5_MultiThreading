import java.security.Signature;

public class SingletonClass
{
    private static SingletonClass object = null;
    private SingletonClass()
    {

    }
    public static SingletonClass getInstance()
    {
        if(object == null)
            object = new SingletonClass();
        return object;
    }
    public static void main(String args[])
    {
        SingletonClass singletonClass = new SingletonClass();
        //SingletonClass singletonClass1 = new SingletonClass();
    }
}
