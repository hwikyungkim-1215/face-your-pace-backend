# -*- coding: utf-8 -*-

import math
import sys


def main(argv):
    bpm_recommend(argv[1], argv[2], argv[3], argv[4])

def bpm_recommend(age,height, target_pace, stride):
    max_heartrate = 220-int(age) # 최대심박수

    workout_level = '저강도' # 걷기, 저강도, 중강도, 고강도 선택 가능하게
   
    # 걷기   : 4  km/h
    # 저강도 : 6  km/h
    # 중강도 : 8  km/h
    # 고강도 : 10 km/h

    min_stride = int(height) * 0.37
    max_stride = int(height) - 100
    if int(height) * 0.45 > max_stride:
        max_stride = int(height) * 0.45
    
    stride = int(stride)
    stride = int(round((min_stride + max_stride)/2,-1))
    print(stride) # 평균 보폭

    if workout_level == '걷기' : target_pace = 900
    elif workout_level =='저강도': target_pace = 600    # 6km/h
    elif workout_level == '중강도' : target_pace = 450  # 8km/h
    elif workout_level == '고강도' : target_pace = 360  # 10km/h




    # 계산 =============================================================
    kilo_per_hour = 3600/target_pace   # km/h
    footnum = math.ceil(100000/stride) # 보폭으로 뛰었을 때 몇번 발걸음을 해야하는지


    recommend_bpm = footnum/(target_pace/60)
    bpm1 = math.trunc(recommend_bpm)
    print(bpm1)
    bpm2 = bpm1

    if (bpm1 % 10 >0 or bpm1%10==0 ) and bpm1%10<5:
        bpm1 = round(bpm1,-1)
        bpm2 = bpm1 - bpm1%10 + 5
    else:
        bpm2 = round(bpm1,-1)
        bpm1 = bpm1 - bpm1%10 + 5

    print('rec bpm = {} ~ {}'.format(bpm1,bpm2))
    #print(recommend_bpm)

if __name__ == '__main__':
    main(sys.argv)

    # 이건 무조건 입력해야하는 정보
    #age = 23 
    #height = 165
    # case 1) 사용자가 입력을 다 했을 때
    # 사용자입력  
    #target_pace = 360   # seconds 타겟 시간
    #stride = 110         # centimeters 보폭
