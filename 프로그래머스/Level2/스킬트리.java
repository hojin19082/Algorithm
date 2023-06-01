package Level2;

public class 스킬트리 {
		
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	        for(int i=0; i<skill_trees.length; i++){
	            int index = 0;
	            int j = 0;
	            for(j=0; j<skill_trees[i].length(); j++){
	                char ch = skill_trees[i].charAt(j);
	                if(!skill.contains(ch+"")) continue;
	                if(skill.indexOf(ch) != index) {
	                    index = 0;
	                    break;
	                }
	                index++;
	            }
	            if(index != 0 || j==skill_trees[i].length()) answer++;
	        }
	        return answer;
	    }

}
