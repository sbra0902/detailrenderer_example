package kaufland.com.detailrendererdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;

import java.io.IOException;

import kaufland.com.productdetailrenderer.renderer.DetailJsonConverter_;
import kaufland.com.productdetailrenderer.renderer.RenderingManager_;
import kaufland.com.productdetailrenderer.renderer.model.DetailData;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootLayout = (LinearLayout) findViewById(R.id.root_layout);

        try {
            DetailData detailData = DetailJsonConverter_.getInstance_(this).mapJsonToDto(IOUtils.toString(getResources().openRawResource(R.raw.detail_raw)));
            RenderingManager_.getInstance_(this).render(mRootLayout, detailData.getGroups(), detailData.getNutrutionTables());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
