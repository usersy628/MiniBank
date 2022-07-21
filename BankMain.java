package ex220318;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataFormat d = new DataFormat();
		Util u = new Util();
		ArrayList<Account> accArr = new ArrayList<>();
		Account ac = new Account();
		ArrayList<UserInfo> userArr = new ArrayList<>();
		UserInfo ui = new UserInfo();

		boolean run = true;
		boolean logCk = false;

		String loginName = "";
		String loginId = "";
		String loginPw = "";
		long loginTot = 0;

		String[] name = { "이순신", "강감찬", "이도열", "보라동", "돌이군", "이장사", "꼬리동", "스프링", "자바동", "홍길동", "이순신", "강감찬", "이도열",
				"보라동", "돌이군", "이장사", "꼬리동", "스프링", "자바동", "홍길동", "이순신", "강감찬", "이도열", "보라동", "돌이군", "이장사", "꼬리동", "스프링",
				"자바동", "홍길동", "이순신", "강감찬", "이도열", "보라동", "돌이군", "이장사", "꼬리동", "스프링", "자바동", "홍길동", "이순신", "강감찬", "이도열",
				"보라동", "돌이군", "이장사", "꼬리동", "스프링", "자바동", "홍길동", "이순신", "강감찬", "이도열", "보라동", "돌이군", "이장사", "꼬리동", "스프링",
				"자바동", "홍길동" };

		for (int i = 0; i < name.length; i++) {
			ui = new UserInfo();
			ui.setId("t" + i);
			ui.setPw("t" + i);
			ui.setName(name[i]);
			ui.setTotal(100000000);
			userArr.add(ui);
		}

		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < 5; j++) {
				ac = new Account();
				long input = u.rdbank();
				loginTot += input;
				ac.setDate(d.getDateTime());
				ac.setType("입금");
				ac.setMoney(input);
				ac.setId(userArr.get(i).getId());
				ac.setName(userArr.get(i).getName());
				ac.setTot(loginTot);
				userArr.get(i).setTotal(loginTot);
				accArr.add(ac);

				ac = new Account();
				input = u.rdbank();
				loginTot -= input;
				ac.setDate(d.getDateTime());
				ac.setType("출금");
				ac.setMoney(-input);
				ac.setId(userArr.get(i).getId());
				ac.setName(userArr.get(i).getName());
				ac.setTot(loginTot);
				userArr.get(i).setTotal(loginTot);
				accArr.add(ac);
			}
		}

		while (run) {
			if (logCk) {
				System.out.println("\t\t*** 환영합니다 " + loginName + "님***");
				System.out.println("1.입금 2.출금 3.잔고 4.개인입출금 5.전체입출금 6.정보수정 7.로그아웃 8.회원리스트 0.종료");
			} else {
				System.out.println("1.입금 2.출금 3.잔고 4.개인입출금 5.전체입출금 6.회원가입 7.로그인 8.회원리스트 0.종료");
			}
			int menu = u.menuCheck("선택");

			switch (menu) {
			case 1:
				if (logCk) {
					ac = new Account();

					long input = u.moneyCheck("예금액 ");
					loginTot += input;
					ac.setDate(d.getDateTime());
					ac.setType("입금");
					ac.setMoney(input);
					ac.setId(loginId);
					ac.setName(loginName);
					ac.setTot(loginTot);

					ui.setTotal(loginTot);

					accArr.add(ac);
					System.out.println(d.getMoneyWonIcon(input) + "이 입금되었습니다");
				} else {
					System.out.println("(System)로그인하세요");
				}
				break;
			case 2:
				if (logCk) {
					ac = new Account();

					long out = u.moneyCheck("출금액 ");
					if (loginTot < out) {
						System.out.println("(System)잔액이 부족합니다");
					} else {
						loginTot -= out;
						ac.setDate(d.getDateTime());
						ac.setType("출금");
						ac.setMoney(out);
						ac.setId(loginId);
						ac.setName(loginName);
						ac.setTot(loginTot);
						ui.setTotal(loginTot);

						accArr.add(ac);
						System.out.println(d.getMoneyWonIcon(out) + "이 출금되었습니다");

					}
				} else {
					System.out.println("(System)로그인하세요");
				}

				break;
			case 3:
				if (logCk) {
					System.out.println(loginName + "님의 잔액은 " + d.getMoneyWonIcon(ui.getTotal()) + "입니다.");
				} else {
					System.out.println("(System)로그인하세요");
				}
				break;
			case 4:
				if (logCk) {
					System.out.println("\t\t\t[ 개인 입출금 리스트 ]");
					System.out.println("\t날짜\t\t\t유형\t\t\t금액\t\t\t잔액");
					System.out.println(
							"=====================================================================================");
					for (int i = 0; i < accArr.size(); i++) {
						if (loginId.equals(accArr.get(i).getId())) {
							System.out.printf("%s\t\t%s\t\t%12s\t\t%12s\n", accArr.get(i).getDate(),
									accArr.get(i).getType(), d.getMoney(accArr.get(i).getMoney()),
									d.getMoney(accArr.get(i).getTot()));
						}
					}
				} else {
					System.out.println("(System)로그인하세요");
				}
				break;

			case 5:
				if (logCk) {
					int m2 = u.menuCheck("1)이름으로 검색하기\n2)아이디로 검색하기\n");
					switch (m2) {
					case 1:
						String nck = u.nameCheck("이름");
						System.out.println("\t\t\t[ 전체 입출금 리스트 ]");
						System.out.println("이름\t날짜\t\t\t\t유형\t\t\t금액\t\t\t잔액");
						System.out.println(
								"==============================================================================================");
						for (int i = 0; i < accArr.size(); i++) {
							if (nck.equals(accArr.get(i).getName())) {
								System.out.printf("%s\t%s\t\t%s\t\t%12s\t\t%12s\n", accArr.get(i).getName(),
										accArr.get(i).getDate(), accArr.get(i).getType(),
										d.getMoney(accArr.get(i).getMoney()), d.getMoney(accArr.get(i).getTot()));
							}
						}
						break;
					case 2:
						String idck = u.nameCheck("아이디");
						System.out.println("\t\t\t[ 전체 입출금 리스트 ]");
						System.out.println("ID\t날짜\t\t\t\t유형\t\t\t금액\t\t\t잔액");
						System.out.println(
								"==============================================================================================");
						for (int i = 0; i < accArr.size(); i++) {
							if (idck.equals(accArr.get(i).getId())) {
								System.out.printf("%s\t%s\t\t%s\t\t%12s\t\t%12s\n", accArr.get(i).getId(),
										accArr.get(i).getDate(), accArr.get(i).getType(),
										d.getMoney(accArr.get(i).getMoney()), d.getMoney(accArr.get(i).getTot()));
							}
						}
						break;
					default:
					}

				} else {
					System.out.println("(System)로그인하세요");
				}
				break;

			case 6:
				if (logCk) {
					System.out.println("\t[ 회원 정보 수정 ]");
					System.out.println("회원 정보를 수정하시겠습니까?");
					int jb = u.menuCheck("1) 비밀번호\n2) 이메일\n3) 주소\n4) 회원탈퇴\n");
					switch (jb) {
					case 1:
						System.out.println("변경할 비밀번호를 입력해주세요 : ");
						for (UserInfo uI : userArr) {
							if (uI.getId().equals(loginId)) {
								uI.setPw(sc.nextLine());
							}
						}
						System.out.println("(System)비밀번호 수정 완료");
						break;
					case 2:
						System.out.println("변경할 이메일을 입력해주세요 : ");
						for (UserInfo uI : userArr) {
							if (uI.getId().equals(loginId)) {
								uI.seteMail(sc.nextLine());
							}
						}
						System.out.println("(System)이메일 수정 완료");
						break;
					case 3:
						System.out.println("변경할 주소를 입력해주세요 : ");
						for (UserInfo uI : userArr) {
							if (uI.getId().equals(loginId)) {
								uI.setAddress(sc.nextLine());
							}
						}
						System.out.println("(System)주소 수정 완료");
						break;
					case 4:
						System.out.println("## 회원 탈퇴 하시겠습니까?");
						int mm1 = u.menuCheck("1.예  2.아니오");
						if (mm1 == 1) {
							for (int i = 0; i < userArr.size(); i++) {
								if (loginId.equals(userArr.get(i).getId())) {
									userArr.remove(userArr.get(i));
									System.out.println("(System)회원 탈퇴 되었습니다.");
									logCk = !logCk;
									break;
								}
							}
						}
					default:
					}
				} else {
					ui = new UserInfo();
					System.out.println("[ 회원가입 ]");
					ui.setId(u.nameCheck("아이디"));
					ui.setPw(u.nameCheck("비밀번호"));
					ui.setName(u.nameCheck("이름"));
					ui.seteMail(u.nameCheck("이메일"));
					ui.setAddress(u.nameCheck("주소"));
					ui.setTotal(loginTot);

					userArr.add(ui);
				}
				break;

			case 7:
				if (logCk) {
					System.out.println("(System)로그아웃 하시겠습니까?");
					int mm = u.menuCheck("1.예 2.아니오");
					if (mm == 1) {
						logCk = !logCk;
						break;
					}
				} else {
					System.out.println("\t\t[ 로그인 ]");
					String idck = u.nameCheck("ID");
					String pwck = u.nameCheck("PASSWORD");
					for (int i = 0; i < userArr.size(); i++) {
						if (idck.equals(userArr.get(i).getId())) {
							if (pwck.equals(userArr.get(i).getPw())) {
								System.out.println("( 로그인 성공! )");

								loginName = userArr.get(i).getName();
								loginId = userArr.get(i).getId();
								loginPw = userArr.get(i).getPw();
								loginTot = userArr.get(i).getTotal();

								ui = userArr.get(i);
								logCk = true;
								break;
							} else {
								System.out.println("(System)비밀번호를 확인하세요");
							}
						}
					}
				}
				break;

			case 8:
				if (logCk) {
					System.out.println("\t\t\t[ 회원리스트 ]");
					System.out.println("이름\tID\tPW\t\t잔고\t이메일\t주소");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < userArr.size(); i++) {
						System.out.printf("%s\t%s\t%s\t%12s\t%s\t%s\n", userArr.get(i).getName(),
								userArr.get(i).getId(), userArr.get(i).getPw(), d.getMoney(userArr.get(i).getTotal()),
								userArr.get(i).geteMail(), userArr.get(i).getAddress());
					}
				} else {
					System.out.println("(System)로그인하세요");
				}
				break;

			case 0:
				System.out.println("프로그램 종료");
				run = false;
				break;

			default:
			}
		}
		sc.close();
	}

}
