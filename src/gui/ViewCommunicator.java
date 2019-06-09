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

    public static WWCellViewController getWWController() {
        return WWController;
    }

    public static WWToolbar getTController() {
        return TController;
    }





}
