class Application {
    public static void main(String[] args) {
        String lang = System.getProperty("lang");
        if (lang == null) {
            lang = "en";
        }

        System.out.println("Język aplikacji: " + lang);
        System.out.println("String[] args:");
        for (String arg : args) {
            System.out.println(" > " + arg);
        }
    }
}
