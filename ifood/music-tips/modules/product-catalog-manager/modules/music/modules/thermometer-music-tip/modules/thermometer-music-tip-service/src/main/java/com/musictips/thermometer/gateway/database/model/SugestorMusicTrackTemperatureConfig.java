package com.musictips.thermometer.gateway.database.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "sugestor-music-track-temperature")
@Getter @Setter
public class SugestorMusicTrackTemperatureConfig implements Serializable {

    private static final long serialVersionUID = 2399746800716408231L;

    @Id
    private String id;

    private RangeOfTemperatures rangeOfTemperatures;

    private String genre;

    private SugestorMusicTrackTemperatureConfig(){
        this.rangeOfTemperatures = new RangeOfTemperatures();
    }


    public static final RangeOfTemperatureBuilder temperature(){
        return new RangeOfTemperatureBuilder(new SugestorMusicTrackTemperatureConfig());
    }

    /**
     * Temperature range builder, lead client API to construct consistent range of temperature
     */
    public static class RangeOfTemperatureBuilder {

        private final SugestorMusicTrackTemperatureConfig sugestorMusicTrackTemperatureConfig;

        public RangeOfTemperatureBuilder(SugestorMusicTrackTemperatureConfig sugestorMusicTrackTemperatureConfig) {
            this.sugestorMusicTrackTemperatureConfig = sugestorMusicTrackTemperatureConfig;
        }

        /**
         * Returns the first contract of range of temperature
         * @return RangeOfTemperatureStartBuilder
         */
        public final RangeOfTemperatureStartBuilder range() {
            return new RangeOfTemperatureStartBuilder();
        }

        /**
         * Start temperature builder
         */
        public class RangeOfTemperatureStartBuilder {

            /**
             * Set start temperature and return the end temperature builder of its range
             *
             * @param temperature
             * @return RangeOfTemperatureEndBuilder
             */
            public RangeOfTemperatureEndBuilder start(Double temperature) {
                RangeOfTemperatureBuilder.this.sugestorMusicTrackTemperatureConfig.rangeOfTemperatures.start = temperature;
                return new RangeOfTemperatureEndBuilder();
            }


            /**
             * End temperature builder of range
             */
            public class RangeOfTemperatureEndBuilder {

                /**
                 * Set end temperature and return the Genre builder
                 *
                 * @param temperature
                 * @return GenreBuilder
                 */
                public GenreBuilder end(Double temperature) {
                    RangeOfTemperatureBuilder.this.sugestorMusicTrackTemperatureConfig.rangeOfTemperatures.end = temperature;
                    return new GenreBuilder();
                }

                /**
                 * Genre builder class, to setup genre in sugestor music track temperature config
                 */
                public class GenreBuilder {

                    /**
                     * Set genre temperature in sugestor music track temperature config and return FinalBuilder
                     *
                     * @param genre
                     * @return FinalBuilder
                     */
                    public FinalBuilder genre(String genre) {
                        RangeOfTemperatureBuilder.this.sugestorMusicTrackTemperatureConfig.genre = genre;
                        return new FinalBuilder();
                    }
                }

                /**
                 * Final builder to return sugestor music track temperature config instance
                 */
                public class FinalBuilder {
                    /**
                     * Finally, It builds a configurated instance of sugestor music track temperature config instance
                     *
                     * @return
                     */
                    public SugestorMusicTrackTemperatureConfig build() {
                        return RangeOfTemperatureBuilder.this.sugestorMusicTrackTemperatureConfig;
                    }
                }
            }
        }
    }

    @Getter @Setter
    public class RangeOfTemperatures implements Serializable {

        private static final long serialVersionUID = -1800893493748830019L;

        private Double start;

        private Double end;
    }
}
