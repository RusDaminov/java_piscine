package app;

//import javafx.beans.binding.ObjectExpression;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static final String PACKAGE = "classes";

    private static final char PKG_SEPARATOR = '.';

    private static final char DIR_SEPARATOR = '/';

    private static final String CLASS_FILE_SUFFIX = ".class";

    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("Classes:");
        List<Class<?>> classList = findClassesFromPackage(PACKAGE);
        for (Class<?> findClass : classList) {
            System.out.println(findClass.getSimpleName());
        }
        System.out.println("---------------------");

        System.out.println("Enter class name:");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            String className = scanner.nextLine();
            System.out.println("---------------------");
            Class<?> clazz = classList.stream()
                    .filter(aClass -> aClass.getSimpleName().equals(className))
                    .findFirst()
                    .get();

            Object object;
            try {
                object = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Class<?>> findClassesFromPackage(String scannedPackage) {
        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }
        File scannedDir = new File(scannedUrl.getFile());
        List<Class<?>> classes = new ArrayList<>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }

    public static boolean listContainsClass(String className, List<Class<?>> classList) {
        for (Class<?> cl : classList) {
            if (className.equals(cl.getSimpleName())) {
                return true;
            }
        }
        return false;
    }
}
