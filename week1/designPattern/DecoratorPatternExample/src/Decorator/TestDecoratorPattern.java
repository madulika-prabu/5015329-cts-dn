package Decorator;

public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Sending notification with Email only:");
        emailNotifier.send("Hiii, this is an email notification!");

        System.out.println("\nSending notification with Email and SMS:");
        smsNotifier.send("Hiii, this is an email and SMS notification!");

        System.out.println("\nSending notification with Email, SMS, and Slack:");
        slackNotifier.send("Hiii, this is an email, SMS, and Slack notification!");
    }
}
