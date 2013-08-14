package com.jiahaoliuliu.android.enumtosharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * The content of the shared preferences is the follow
 * <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
 * <map>
 *  <string name="MyEnum">ENUM3</string>
 * </map>
 * @author jiahao liu
 * @Email jiahaoliuliu@gmail.com
 * @Twitter @jiahaoliuliu
 *
 */
public class MainActivity extends Activity {
	
	SharedPreferences sp;
	SharedPreferences.Editor editor;

	private TextView textView;

	public enum MyEnum {
	    ENUM1, ENUM2, ENUM3, ENUM4;

	    public static MyEnum toMyEnum (String myEnumString) {
	        try {
	            return valueOf(myEnumString);
	        } catch (Exception ex) {
	                // For error cases
	            return ENUM1;
	        }
	    }
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp = this.getPreferences(Context.MODE_PRIVATE);
		editor = sp.edit();
		
		textView = (TextView)findViewById(R.id.textView);
		
		// TODO: Create a list of radio buttons to allow
		// the user select the data from the interface
		setMyEnum(MyEnum.ENUM3);
		
		switch (getMyEnum()) {
		case ENUM1: {
			textView.setText("Enum1");
			break;
		}
		case ENUM2: {
			textView.setText("Enum2");
			break;
		}
		case ENUM3: {
			textView.setText("Enum3");
			break;
		}
		case ENUM4: {
			textView.setText("Enum4");
			break;
		}
		}
	}

	public void setMyEnum(MyEnum myEnum) {
	    editor.putString("MyEnum", myEnum.toString());
	    editor.commit();
	}
	
	public MyEnum getMyEnum() {
	    String myEnumString = sp.getString("MyEnum", MyEnum.ENUM1.toString());
	    return MyEnum.toMyEnum(myEnumString);
	}
}
