import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import sun.plugin2.jvm.RemoteJVMLauncher;

import javax.naming.SizeLimitExceededException;
import javax.security.auth.callback.Callback;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.Closeable;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2015/12/13.
 */
public class Test {
    public static int a = 5;
    public static void main(String[] args) {
//        A.d = new D();
//        A.d = null;
//        System.out.println("sun.boot.class.path:" + System.getProperty("sun.boot.class.path"));
//
//        System.out.println("java.ext.dirs:" + System.getProperty("java.ext.dirs"));
//
//        System.out.println("java.class.path:" +System.getProperty("java.class.path"));
//
//        ClassLoader cl = Thread.currentThread().getContextClassLoader();//ClassLoader.getSystemClassLoader()
//
//        System.out.println("getContextClassLoader:" +cl.toString());
//
//        System.out.println("getContextClassLoader.parent:" +cl.getParent().toString());
//
//        System.out.println("getContextClassLoader.parent2:" +cl.getParent().getParent());
        func();
    }
    public static synchronized void func() {
//        Test test = new Test();
//        TreeMap t = new TreeMap();
//        synchronized (test) {
//            notify();
//        }
        a--;
        System.out.println(a);
        if (a > 0)
            func();
    }
}

class A extends B{
    public static int a = 1;

    public static D d = null;

    public A() {
        System.out.println("init a");
    }

    static {
        System.out.println("a : " + a);
        System.out.println("class a static");
    }
}

class B {
    public B() {
        System.out.println("init b");
    }
    public static int b = 1;
    static {
        System.out.println("b : " + b);
        System.out.println("class b static");
    }
}

class C {
    public C() {
        System.out.println("cons c");
    }

    private A a = new A();

    {
        System.out.println("block c");
    }
    public final D d = new D();

    static {
        System.out.println("class c");
    }

    private static B b = new B();
}

class D {
    public int a = 3;
    public int b;
    static {
        System.out.println("class d");
    }
    {
        System.out.println("a: " + a);
        System.out.println("this: " + this);
    }
    public D(){
        a = 1;
        b = 2;
        System.out.println("d:" + A.d);
    }
}

class ResourceFactory {
    public int a;
    public class ResourceHolder {
//        public  Resource resource = new Resource();
        public ResourceHolder() {

        }
    }

    public static void getResource() {
//        return ResourceHolder.resource;
    }

    public void f(){
        ResourceHolder holder = new ResourceHolder();
    }
}

class Resource {
    public void func(){
        ResourceFactory factory = new ResourceFactory();
//        ResourceFactory.ResourceHolder resourceHolder = new ResourceFactory.ResourceHolder();
    }
}

class Cam {
    public static List<Integer> filter(int ceil) {
        boolean[] mark = new boolean[ceil];
        List<Integer> prime = new ArrayList<>();
        prime.add(1);
        for (int i = 2; i <= ceil; i++) {
            if (!mark[i-1]) {
                prime.add(i);
                for (int j = i * 2; j <= ceil; j+=i) {
                    mark[j-1] = true;
                }
            }
        }
        return prime;
    }

//    public int[] distance(int[] nodes) {
//        int[] distances = new int[nodes.length - 1];
//        List<Integer> primes = filter(nodes[nodes.length - 1]);
//        int i = 0;
//        int j = 1;
//        while (true) {
//            if (i == primes.size()) {
//                if (j == nodes.length)
//                    break;
//                else
//                    j++;
//            }
//            if (primes.get(i) < nodes[0]) {
//                i++;
//                continue;
//            } else {
//                if (primes.get(i) < nodes[j]) {
//                    distances[j-1]++;
//                    i++;
//                } else {
//                    j++;
//                }
//            }
//        }
//    }
}


