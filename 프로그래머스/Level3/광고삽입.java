package Level3;
public class 광고삽입 {
	class Solution {
	    //동영상 재생 시간에 대한 배열 생성 후
	    //log마다 시작과 끝에 대해 시간 배열에 ++
	    //sum배열에는 각 초마다 재생된 시간이 담겨 있음.
	    public String solution(String play_time, String adv_time, String[] logs) {
	        int answer = 0;
	        int playtime= strToInt(play_time);
	        int advtime= strToInt(adv_time);
	        int[] sum = new int[playtime+1];
	        for(String str: logs){
	            String[] arr= str.split("-");
	            int start= strToInt(arr[0]);
	            int end= strToInt(arr[1]);

	            for(int i=start; i<end; i++){
	                sum[i]++;
	            }
	        }
	        long max=0;
	        for(int i=1; i<advtime; i++){
	            max+= sum[i];
	        }
	        
	        long now = max;
	        for(int i=0, j=advtime; j<playtime; i++, j++){
	            now = now-sum[i]+sum[j];
	            if(now>max){
	                answer = i+1;
	                max = now;
	            }
	        }
	        


	        return intToStr(answer);
	    }
	    public int strToInt(String time_str){
	        String[] arr= time_str.split(":");
	        int time= Integer.parseInt(arr[0])*3600
	                +Integer.parseInt(arr[1])*60+Integer.parseInt(arr[2]);
	        return time;
	    }
	    
	     public String intToStr(int time){
	        String hh, mm, ss;
	        hh= (time/3600)>9? (time/3600)+"":"0"+time/3600;
	        time%=3600;
	        mm= (time/60)>9? (time/60)+"":"0"+time/60;
	        time%=60;
	        ss= time>9? time+"":"0"+time;
	        
	        return hh+":"+mm+":"+ss;
	    }

	}

}
