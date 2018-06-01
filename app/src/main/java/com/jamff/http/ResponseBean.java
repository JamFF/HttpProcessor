package com.jamff.http;

/**
 * 描述：
 * 作者：JamFF
 * 创建时间：2018/5/31 12:48
 */
public class ResponseBean {

    /**
     * resultcode : 200
     * reason : successed!
     * result : {"sk":{"temp":"32","wind_direction":"西南风","wind_strength":"4级","humidity":"61%","time":"15:26"},"today":{"temperature":"28℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"持续无风向微风","week":"星期四","city":"深圳","date_y":"2018年05月31日","dressing_index":"炎热","dressing_advice":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"适宜","exercise_index":"适宜","drying_index":""},"future":{"day_20180531":{"temperature":"28℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"持续无风向微风","week":"星期四","date":"20180531"},"day_20180601":{"temperature":"28℃~33℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期五","date":"20180601"},"day_20180602":{"temperature":"27℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期六","date":"20180602"},"day_20180603":{"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期日","date":"20180603"},"day_20180604":{"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期一","date":"20180604"},"day_20180605":{"temperature":"27℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期二","date":"20180605"},"day_20180606":{"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期三","date":"20180606"}}}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * sk : {"temp":"32","wind_direction":"西南风","wind_strength":"4级","humidity":"61%","time":"15:26"}
         * today : {"temperature":"28℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"持续无风向微风","week":"星期四","city":"深圳","date_y":"2018年05月31日","dressing_index":"炎热","dressing_advice":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"适宜","exercise_index":"适宜","drying_index":""}
         * future : {"day_20180531":{"temperature":"28℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"持续无风向微风","week":"星期四","date":"20180531"},"day_20180601":{"temperature":"28℃~33℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期五","date":"20180601"},"day_20180602":{"temperature":"27℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期六","date":"20180602"},"day_20180603":{"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期日","date":"20180603"},"day_20180604":{"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期一","date":"20180604"},"day_20180605":{"temperature":"27℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期二","date":"20180605"},"day_20180606":{"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期三","date":"20180606"}}
         */

        private SkBean sk;
        private TodayBean today;
        private FutureBean future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public FutureBean getFuture() {
            return future;
        }

        public void setFuture(FutureBean future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * temp : 32
             * wind_direction : 西南风
             * wind_strength : 4级
             * humidity : 61%
             * time : 15:26
             */

            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * temperature : 28℃~34℃
             * weather : 多云
             * weather_id : {"fa":"01","fb":"01"}
             * wind : 持续无风向微风
             * week : 星期四
             * city : 深圳
             * date_y : 2018年05月31日
             * dressing_index : 炎热
             * dressing_advice : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
             * uv_index : 中等
             * comfort_index :
             * wash_index : 较适宜
             * travel_index : 适宜
             * exercise_index : 适宜
             * drying_index :
             */

            private String temperature;
            private String weather;
            private WeatherIdBean weather_id;
            private String wind;
            private String week;
            private String city;
            private String date_y;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 01
                 * fb : 01
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * day_20180531 : {"temperature":"28℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"持续无风向微风","week":"星期四","date":"20180531"}
             * day_20180601 : {"temperature":"28℃~33℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期五","date":"20180601"}
             * day_20180602 : {"temperature":"27℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期六","date":"20180602"}
             * day_20180603 : {"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期日","date":"20180603"}
             * day_20180604 : {"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期一","date":"20180604"}
             * day_20180605 : {"temperature":"27℃~31℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期二","date":"20180605"}
             * day_20180606 : {"temperature":"27℃~32℃","weather":"雷阵雨","weather_id":{"fa":"04","fb":"04"},"wind":"持续无风向微风","week":"星期三","date":"20180606"}
             */

            private DayBean day_1;
            private DayBean day_2;
            private DayBean day_3;
            private DayBean day_4;
            private DayBean day_5;
            private DayBean day_6;
            private DayBean day_7;

            public DayBean getDay_1() {
                return day_1;
            }

            public void setDay_1(DayBean day_1) {
                this.day_1 = day_1;
            }

            public DayBean getDay_2() {
                return day_2;
            }

            public void setDay_2(DayBean day_2) {
                this.day_2 = day_2;
            }

            public DayBean getDay_3() {
                return day_3;
            }

            public void setDay_3(DayBean day_3) {
                this.day_3 = day_3;
            }

            public DayBean getDay_4() {
                return day_4;
            }

            public void setDay_4(DayBean day_4) {
                this.day_4 = day_4;
            }

            public DayBean getDay_5() {
                return day_5;
            }

            public void setDay_5(DayBean day_5) {
                this.day_5 = day_5;
            }

            public DayBean getDay_6() {
                return day_6;
            }

            public void setDay_6(DayBean day_6) {
                this.day_6 = day_6;
            }

            public DayBean getDay_7() {
                return day_7;
            }

            public void setDay_7(DayBean day_7) {
                this.day_7 = day_7;
            }

            public static class DayBean {
                /**
                 * temperature : 28℃~34℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 持续无风向微风
                 * week : 星期四
                 * date : 20180531
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }
        }
    }
}
