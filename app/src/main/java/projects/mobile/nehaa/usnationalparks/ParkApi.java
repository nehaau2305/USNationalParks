package projects.mobile.nehaa.usnationalparks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * ParkApi retrofit interface accesses the US National Park Service Parks API
 * by searching for a park using a query string.
 */
public interface ParkApi {
    /**
     * Search the NPS parks API for the park in the given query.
     * @param apiKey unique NPS API key required for authorization obtained through www.nps.gov/subjects/developer/get-started.htm.
     * @param query user provided search query string for desired park information.
     * @return {@link Call} object which can be used to asynchronously/synchronously fetch a {@link ParkResponse}
     *      containing a list of matching parks.
     */
    @GET("parks")
    Call<ParkResponse> searchParks(
            @Header("X-Api-Key") String apiKey,
            @Query("q") String query
    );

}
