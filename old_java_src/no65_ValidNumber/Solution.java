package no65_ValidNumber;
/*
 * Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

    Numbers 0-9
    Exponent - "e"
    Positive/negative sign - "+"/"-"
    Decimal point - "."

Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.

 */
public class Solution {

	
    enum STATE{
        WHITE_SPACES,
        PLUS_MINUS,
        NUM_BEFORE_DOT,
        DOT,
        NUM_DOT,
        NUM_AFTER_DOT,
        EXP,
        EXP_PLUS_MINUS,
        NUM_AFTER_EXP,
        WHITE_SPACE_AT_END
    };
    
    public boolean isNumber(String s) {
    	if(s==null) {
    		return false;
    	}
    	STATE state= STATE.WHITE_SPACES;
    	for(char c: s.toCharArray()) {
    		switch(state) {
    		case WHITE_SPACES:
    			if(c==' ' || c=='\t') { 
    				//keep in current state
    			}
    			else if(c=='+' || c=='-') {
    				state=STATE.PLUS_MINUS;
    			}
    			else if(c>='0' && c<='9') {
    				state=STATE.NUM_BEFORE_DOT;
    			}
    			else if(c=='.') {
    				state=STATE.DOT;
    			}
    			else {
    				return false;
    			}
    			break;
    		case PLUS_MINUS:
    			if(c>='0' && c<='9') {
    				state=STATE.NUM_BEFORE_DOT;
    			}
    			else if(c=='.') {
    				state=STATE.DOT;
    			}
    			else {
    				return false;
    			}
    			break;
    		case NUM_BEFORE_DOT:
    			if(c>='0' && c<='9') {
    				//keep in current state
    			}
    			else if(c=='.') {
    				state=STATE.NUM_DOT;
    			}
    			else if(c=='e'||c=='E') {
    				state=STATE.EXP;
    			}
    			else if(c==' '||c=='\t') {
    				state=STATE.WHITE_SPACE_AT_END;
    			}
    			else {
    				return false;
    			}
    			break;
    		case NUM_DOT:
    			if(c>='0' && c<='9') {
    				state=STATE.NUM_AFTER_DOT;
    			}
    			else if(c=='e' || c=='E') {
    				state=STATE.EXP;
    			}
    			else if(c==' ' || c=='\t') {
    				state=STATE.WHITE_SPACE_AT_END;
    			}
    			else {
    				return false;
    			}
    			break;
    		case DOT:
    			if(c>='0' && c<='9') {
    				state=STATE.NUM_AFTER_DOT;
    			}
    			else {
    				return false;
    			}
    			break;
    		case NUM_AFTER_DOT:
    			if(c>='0' && c<='9') {
    				//keep in same state
    			}
    			else if(c=='e'||c=='E') {
    				state=STATE.EXP;
    			}
    			else if(c==' '||c=='\t') {
    				state=STATE.WHITE_SPACE_AT_END;
    			}
    			else {
    				return false;
    			}
    			break;
    		case EXP:
    			if(c>='0' && c<='9') {
    				state=STATE.NUM_AFTER_EXP;
    			}
    			else if(c=='+' || c=='-') {
    				state=STATE.EXP_PLUS_MINUS;
    			}
    			else {
    				return false;
    			}
    			break;
    		case EXP_PLUS_MINUS:
    			if(c>='0' && c<='9') {
    				state=STATE.NUM_AFTER_EXP;
    			}
    			else {
    				return false;
    			}
    			break;
    		case NUM_AFTER_EXP:
    			if(c>='0' && c<='9') {
    				//keep in same state
    			}
    			else if(c==' ' || c=='\t') {
    				state=STATE.WHITE_SPACE_AT_END;
    			}
    			else {
    				return false;
    			}
    			break;
    		case WHITE_SPACE_AT_END:
    			if(c==' ' || c=='\t') {
    				//keep in same state
    			}
    			else {
    				return false;
    			}
    			break;
    		}
    		
    	}
    	return (state == STATE.NUM_BEFORE_DOT
    			|| state==STATE.NUM_DOT
    			|| state==STATE.NUM_AFTER_DOT 
    			|| state==STATE.NUM_AFTER_EXP
    			|| state==STATE.WHITE_SPACE_AT_END
    			);
    }
}
