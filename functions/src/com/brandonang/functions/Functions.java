package com.brandonang.functions;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.HVArrangement;
import com.google.appinventor.components.runtime.util.MediaUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.view.View;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import java.io.IOException; 

public class Functions extends AndroidNonvisibleComponent {
    private Activity activity;
    private Context context;
    private Button button;
    private String txtBoxText;

    public Functions(ComponentContainer container) {
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction
    public void CreateButton(HVArrangement layout){
        View view = layout.getView();
        button = new Button(this.context);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick();
            }
        });
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(button);
    }

    @SimpleEvent
    public void OnClick(){
        EventDispatcher.dispatchEvent(this, "OnClick");
    }

    @SimpleFunction
    public void CreateTextBox(HVArrangement layout, String hint, String text){
        txtBoxText = text;
        View view = layout.getView();
        EditText textBox = new EditText(this.context);
        textBox.setHint(hint);
        textBox.setText(text);
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(textBox);
    }

    @SimpleFunction
    public void CreateImage(HVArrangement layout, String image){
        View view = layout.getView();
        ImageView imageView = new ImageView(this.context);
        try {
            Bitmap bitmap = MediaUtil.getBitmapDrawable(form, image).getBitmap();
            imageView.setImageBitmap(bitmap);
            FrameLayout frameLayout = (FrameLayout) view;
            frameLayout.addView(imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SimpleFunction
    public void CreateToast(String message, boolean isLong){
        Toast toast;
        if(isLong){
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @SimpleFunction
    public void CreateChooseNotifier(String title, String message, String button1Text, String button2Text){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(button1Text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Got It", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton(button2Text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Got It", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @SimpleFunction
    public void CreateMessageNotifier(String title, String message, String buttonText){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

   @SimpleFunction
   public void CreateLabel(HVArrangement layout, String text) {
    View view = layout.getView();
    TextView label = new TextView(this.context);
    label.setText(text);
    FrameLayout frameLayout = (FrameLayout) view;
    frameLayout.addView(label);
  }

  @SimpleProperty
  public String TextBoxText() {
    return txtBoxText;
  }
}
