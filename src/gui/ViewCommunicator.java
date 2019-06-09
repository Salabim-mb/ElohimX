package gui;

public class ViewCommunicator {

    private static WWCellViewController WWController;
    private static WWToolbar TController;


    public static void setWWController(WWCellViewController WWController) {
        ViewCommunicator.WWController = WWController;
    }

    public static void setToolbarController(WWToolbar TController){

        ViewCommunicator.TController = TController;
    }

    public static void setWWGenNumber(int value){

        WWController.setGenNumber(value);
        System.out.println(WWController.getGenNumber());

    }

    public static void setWWGboardHeight(int value){

        WWController.setBoardHeight(value);

    }


    public static void setWWboardWidth(int value){

        WWController.setBoardWidth(value);

    }


    public static void setWWEndlessMode(boolean isOn){

        WWController.setEndlessMode(isOn);

    }





}
