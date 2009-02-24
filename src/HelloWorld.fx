
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

Stage {
  title: "Die, Ajax! - Hello World"
  width: 250
  height: 250
  scene: Scene {
          content: [
      Text {
        content: "Hello World!"
        x:0
        y:12
        font: Font {
          name: "Sans Serif"
          size: 12
        }
      }
          ]
  }
}