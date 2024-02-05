import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.simplebus.R
import com.example.simplebus.aPI.BusData
import com.example.simplebus.aPI.BusDataAdapter
import com.example.simplebus.aPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var busSearch: EditText
    private lateinit var showBusData: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        busSearch = findViewById(R.id.busSearch)
        showBusData = findViewById(R.id.showBusData)

        busSearch.setOnClickListener {
            fetchBusData()
        }
    }

    private fun fetchBusData() {
        val apiKey = "your_api_key"  // Replace with your actual API key
        val datasetId = "someDatasetId"

        RetrofitClient.instance.getTimetables(apiKey, "your_admin_area")
            .enqueue(object : Callback<List<BusData>> {
                override fun onResponse(call: Call<List<BusData>>, response: Response<List<BusData>>) {
                    if (response.isSuccessful) {
                        val busDataList = response.body() ?: emptyList()

                        if (busDataList.isNotEmpty()) {
                            // Update the RecyclerView adapter with the new data
                            showBusData.adapter = BusDataAdapter(busDataList)
                        } else {
                            // Handle case where no data is received
                            // You can show a message or take appropriate action
                        }
                    } else {
                        // Handle unsuccessful response (e.g., server error)
                        // You can show an error message or take appropriate action
                    }
                }

                override fun onFailure(call: Call<List<BusData>>, t: Throwable) {
                    // Handle failure
                }
            })
    }
}
