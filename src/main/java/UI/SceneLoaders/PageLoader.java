package UI.SceneLoaders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class PageLoader {
    private static String FXML_name;
    //THEME/LANGUAGE settings for css loading
    private static boolean THEME_b=false;  //false-blue, true-yellow
    private static boolean LANG_b=false;  //false-EN, true-RO
    private static boolean inSettings=false; //for DetectGPU when backBtn to return to settings or to Initial_setup
    private static boolean notFirstInit=false; // for language selection in InitialSetup when coming from GpuDet
    private static String CSS_theme;
    private static String CSS_lang;

    //main components
    private static Parent root;
    private static Scene scene;
    private static Stage stage;

    public static void setThemeb(boolean theme){//false for blue, true for yellow
        THEME_b=theme;
    }

    public static void setLangb(boolean language) {//false for EN, true for RO
        LANG_b=language;
    }

    public enum page_select {INITIAL_SETUP, MENU, SETTINGS, HISTORY, LOADING, DETECT_GPU};

    private static void setPage(page_select page){

        switch (page) {
            case INITIAL_SETUP -> {

                if(!notFirstInit) {
                    if (THEME_b)
                        CSS_theme = PageLoader.class.getResource("/UI/css/InitialSetup/Yellow_init.css").toExternalForm();
                    else
                        CSS_theme = PageLoader.class.getResource("/UI/css/InitialSetup/Blue_init.css").toExternalForm();
                }
                else CSS_theme = PageLoader.class.getResource("/UI/css/InitialSetup/NoTheme_init.css").toExternalForm();

                if(LANG_b) {
                    FXML_name="/UI/pages/ENG/Initial_setup.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/InitialSetup/RO_init.css").toExternalForm();
                }
                else {
                    FXML_name="/UI/pages/ENG/Initial_setup.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/InitialSetup/EN_init.css").toExternalForm();
                }
            }
            case MENU -> {

                if (THEME_b)
                    CSS_theme = PageLoader.class.getResource("/UI/css/MainMenu/Yellow_menu.css").toExternalForm();
                else CSS_theme = PageLoader.class.getResource("/UI/css/MainMenu/Blue_menu.css").toExternalForm();

                if (LANG_b) {
                    FXML_name="/UI/pages/ENG/main.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/MainMenu/RO_menu.css").toExternalForm();
                }
                else{
                    FXML_name="/UI/pages/ENG/main.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/MainMenu/EN_menu.css").toExternalForm();
                }

            }
            case HISTORY -> {

                if (THEME_b)
                    CSS_theme = PageLoader.class.getResource("/UI/css/History/Yellow_hist.css").toExternalForm();
                else CSS_theme = PageLoader.class.getResource("/UI/css/History/Blue_hist.css").toExternalForm();

                if (LANG_b) {
                    FXML_name="/UI/pages/ENG/History.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/History/RO_hist.css").toExternalForm();
                }
                else {
                    FXML_name="/UI/pages/ENG/History.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/History/EN_hist.css").toExternalForm();
                }

            }
            case SETTINGS -> {

                if (THEME_b)
                    CSS_theme = PageLoader.class.getResource("/UI/css/Settings/Yellow_set.css").toExternalForm();
                else CSS_theme = PageLoader.class.getResource("/UI/css/Settings/Blue_set.css").toExternalForm();

                if (LANG_b) {
                    FXML_name="/UI/pages/ENG/Settings.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/Settings/RO_set.css").toExternalForm();
                }
                else {
                    FXML_name="/UI/pages/ENG/Settings.fxml";
                    CSS_lang = PageLoader.class.getResource("/UI/css/Settings/EN_set.css").toExternalForm();
                }

                inSettings=true;
            }
            case LOADING ->{
                FXML_name = "/UI/pages/ENG/loadingScreen.fxml";
            }
            case DETECT_GPU -> {
                notFirstInit=true;
                FXML_name= "/UI/pages/ENG/GpuDet.fxml";
            }
        }

    }

    public static boolean getInSettings(){
        return inSettings;
    }
    public static boolean getLANG_b(){ return LANG_b;}
    public static void load(ActionEvent event, page_select page) throws IOException {

        setPage(page);
        //setting up scene with its root
        root= FXMLLoader.load(PageLoader.class.getResource(FXML_name));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        //css styling
        if(page!=page_select.LOADING && page!=page_select.DETECT_GPU){
            scene.getStylesheets().add(CSS_theme);
            scene.getStylesheets().add(CSS_lang);
        }
        //loading stage
        stage.setScene(scene);
        stage.show();
    }
}
