public class Program {
    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        try {
            if (args.length == 1) {
                String[] myArgs = args[0].split("=");
                if (!myArgs[0].equals("--current-folder")) {
                    System.out.println("Wrong arguments\n");
                    System.exit(-1);
                } else {
                    myArgs = args[0].split("--current-folder=");
                }
                if (myArgs.length != 2) {
                    System.out.println("Wrong arguments\n");
                    System.exit(-1);
                }
                mainMenu.setDirectory(myArgs[1]);
            } else if (args.length != 0) {
                System.out.println("Wrong arguments\n");
                System.exit(-1);
            }
            mainMenu.startMenu();
        }
        catch (WrongPath wrongPath) {
            System.out.println("Wrong initial directory");
            System.exit(-1);
        }
    }
}
