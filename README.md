# Digital-Signature

#### Digital Signature
<summary> 📝 </summary>

$m = hash$(PDF)

  
##### 1. 키 생성 (KeyGen) <br/>
* Alice의 공개키: $A_{pk}$  
* Alice의 개인키: $A_{sk}$
* Bob의 공개키: $B_{pk}$  
* Bod의 개인키: $B_{sk}$

##### 2. 서명(Sign) <br/>
* 사용한 library: [bouncycastle](https://www.bouncycastle.org/ "보안에서 많이 사용한다함")
* sign: SHA256withRSA($m, A_{sk}$)

##### 2. 검증(Verify) <br/>

</details>

#### TimeStamp
<details>
<summary> ⌚ </summary>









