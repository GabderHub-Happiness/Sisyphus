package com.PUSHISTAYA0ZATOCHKA.Sisyphus;

import static com.almasb.fxgl.dsl.FXGL.*;
import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
//import com.almasb.fxgl.input.Input;
//import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;

public class Sisyphus extends GameApplication {
	protected void initSettings(GameSettings settings) {
		settings.setWidth(500); //длина окна
		settings.setHeight(1000); //#высота окна
		settings.setTitle("Sisyphus"); //название окна
		settings.setVersion("0.1 gamma version"); //название версии(после названия окна)
		settings.setFullScreenFromStart(false); // задать полноэкранный режим с старта
		settings.setIntroEnabled(true); // заставка в запуске
		settings.setMainMenuEnabled(true); // включить главное меню
		settings.setApplicationMode(ApplicationMode.DEVELOPER); // режимы (DEBUG(режим отладки, выводит меню отладки),DEVELOPER(режим разработчика),RELEASE(блокирует все выходные сообщения, где сообщается о фатальной ошибке))
	}
	
    protected void initGameVars1(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }
    private Entity player;
	protected void initGame() {
	    player = FXGL.entityBuilder()
	            .at(200, 200) // положение прямоугольника в окне
	            .view(new Rectangle(25, 25, Color.BLACK)) //прямоугольник(размерами: 25х25 цвет:чёрный)
	            .buildAndAttach();
	}
	
	protected void initPhysics() {
		
	}
	
	protected void initUI() {
        Text textPixels = new Text(); // максимальное значение 2 000 000 000, после него счётчик ломается и идёт в обратную.
        textPixels.setTranslateX(50); // расположение счётчика по Х
        textPixels.setTranslateY(50); // расположение счётчика по Y

        textPixels.textProperty().bind(getWorldProperties().intProperty("pixelsMoved").asString());

        getGameScene().addUINode(textPixels); // добавление графической сцены
	}
	protected void onUpdate(double rpf) {}
		
	protected void initGameVars(Map<String, Object> vars) {
		
	    vars.put("pixelsMoved", 0);
	    FXGL.onKey(KeyCode.W, () -> {
	        player.translateY(-1); // движение вверх(скорость определяется по оси Y(-1) 
	        inc("pixelsMoved", 1);}); // счётчик прибовляющий очки по времени нажатия
	    
	    vars.put("pixelsMoved", 0);
	    FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-1); // движение вправо
            inc("pixelsMoved", 1);});
	    
	    vars.put("pixelsMoved", 0);
	    FXGL.onKey(KeyCode.S, () -> {
            player.translateY(1); // движение вниз
            inc("pixelsMoved", 1);});
	    
	    vars.put("pixelsMoved", 0);
	    FXGL.onKey(KeyCode.D, () -> {
            player.translateX(1); // движение  вправо 
            inc("pixelsMoved", 1);});
	}
	public static void main(String[] args) {
		launch(args);
	}
}
